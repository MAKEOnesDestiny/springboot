package com.zhou.springboot.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReturnInfo {

    String example() default "";

    String meaning() default "";

    Class returnClass() default Void.class;

    Class complexInfo() default Void.class;

}
