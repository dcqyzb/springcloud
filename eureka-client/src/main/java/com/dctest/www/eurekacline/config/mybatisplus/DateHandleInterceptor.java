package com.dctest.www.eurekacline.config.mybatisplus;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Mr.Deng
 * @date 2019/2/22 15:20
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class})})
public class DateHandleInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行请求方法，并将所得结果保存到result中
        Object result = invocation.proceed();
        if (result instanceof ArrayList) {
            ArrayList resultList = (ArrayList) result;
            for (int i = 0; i < resultList.size(); i++) {
                if (resultList.get(i) instanceof Map) {
                    Map resultMap = (Map) resultList.get(i);
                    for (Object object : resultMap.entrySet()) {
                        Map.Entry o = (Map.Entry) object;
                        Object value = o.getValue();
                        if (value instanceof Date) {
                            Date d = (Date) value;
                            if (this.needConvert(d)) {
                                //设置为空
                                value = null;
                            }
                        }
                    }
                } else {
                    this.convert(resultList.get(i));
                }
            }
        }
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    public void convert(Object o) {
        Date date = null;
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(Date.class)) {
                field.setAccessible(true);
                try {
                    date = (Date) field.get(o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.needConvert(date)) {
                    try {
                        field.set(o, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean needConvert(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2000);
        if (date != null && date.before(instance.getTime())) {
            return true;
        } else {
            return false;
        }
    }
}
