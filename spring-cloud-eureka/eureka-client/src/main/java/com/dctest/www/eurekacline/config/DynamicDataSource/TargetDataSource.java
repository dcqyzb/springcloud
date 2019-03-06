package com.dctest.www.eurekacline.config.DynamicDataSource;

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 * @author Mr.Deng
 * @date 2019/2/22 14:44
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
