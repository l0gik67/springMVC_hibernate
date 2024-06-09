package org.l0gik67.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    @Around("execution(* org.l0gik67.dao.*.*(..))")
    public Object aroundAllRepositoryAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String name = methodSignature.getName();

        System.out.println(name + " начал работу");
        Object result = joinPoint.proceed();
        System.out.println(name + " закончил работу");
        return result;
    }
}
