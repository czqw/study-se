package com.czq.aboutclass;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/2
 */
@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD})
@Retention(RUNTIME)
public @interface NotNullProperty {
    String value() default "";
}
