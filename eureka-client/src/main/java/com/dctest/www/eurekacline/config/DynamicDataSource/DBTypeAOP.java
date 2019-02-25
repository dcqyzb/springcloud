package com.dctest.www.eurekacline.config.DynamicDataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 动态数据源aop
 * @author Mr.Deng
 * @date 2019/2/22 14:46
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@Aspect
@Order(-10)
@Component
public class DBTypeAOP {

    @Before("@annotation(targetDataSource)")
    public void before(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        //获取当前的指定的数据源;
        System.out.println("---------------before---------------");
        String dsId = targetDataSource.value();
        //如果不在我们注入的所有的数据源范围之内，那么输出警告信息，系统自动使用默认的数据源。
        if (!DbContextHolder.containsDataSource(dsId)) {
            System.err.println("数据源[{}]不存在，使用默认数据源 > {}" + targetDataSource.value() + joinPoint.getSignature());
        } else {
            System.out.println("Use DataSource : {} > {}" + targetDataSource.value() + joinPoint.getSignature());
            //找到的话，那么设置到动态数据源上下文中。
            DbContextHolder.setDbType(targetDataSource.value());
        }
    }

    @After("@annotation(targetDataSource)")
    public void after(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        System.out.println("--------------after----------------");
        System.out.println("Revert DataSource : {} > {}" + targetDataSource.value() + joinPoint.getSignature());
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DbContextHolder.clearDbType();
    }

}
