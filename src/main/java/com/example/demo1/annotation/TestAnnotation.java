package com.example.demo1.annotation;


import java.lang.annotation.*;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestAnnotation
 * @date 2019/10/24  17:21
 */
@Target({ElementType.METHOD, ElementType.TYPE , ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String testName() default  "10086";
}
