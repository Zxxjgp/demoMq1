package com.example.demo1.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestAnnotationHandle
 * @date 2019/10/24  19:44
 */
@Component
//@Aspect
public class TestAnnotationHandle {
/*    @Pointcut("@annotation(com.example.demo1.annotation.TestAnnotation)")
    public void setAnnotation() {
    }

    @Around("setAnnotation()")
    public void testString(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Signature signature1 = joinPoint.getSignature();
        String name = signature1.getName();

        Object args = joinPoint.getArgs()[0];

         Method[] methods = getClass().getMethods();


        System.out.println("1111111111111111111111");

        joinPoint.proceed();
    }*/

}
