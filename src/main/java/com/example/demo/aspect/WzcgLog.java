package com.example.demo.aspect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WzcgLog {

    String opsValue() default "";
    String remarkField() default "";
    boolean onlyLogOnSuccess() default false;
    boolean isDel() default false;
}
