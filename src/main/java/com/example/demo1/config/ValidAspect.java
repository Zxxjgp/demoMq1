package com.example.demo1.config;

import com.example.demo1.core.ActionResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;



/**
 * @author : jpg
 */
@Aspect
@Component
public class ValidAspect {

    @Around("execution(com.example.demo1.core.ActionResult com.example.*.web..*.*(..)))")
    public Object doValid(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        if (args.length >1) {
            for ( Object o : args) {
                if ( o instanceof  BindingResult) {
                   if(((BindingResult) o).hasErrors()) {
                       String defaultMessage = ((BindingResult) o).getFieldError().getDefaultMessage();
                       return new ActionResult(2,defaultMessage);
                   }
                }
            }
        }
        return pjp.proceed();
    }
}
