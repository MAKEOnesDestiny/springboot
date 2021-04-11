package com.zhou.springboot.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamInfo {

    String example() default ""; //支持json文本自动转为Map

    String meaning() default "";

    boolean required() default false; //注意：这里的默认值


    Class complexInfo() default Void.class; //代表的不是参数的类型，而是参数相关信息存放的类
}
