package com.borris.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class TestAspect {


    @Before("PointcutConfig.allControllerMethod()")
    public void beforeAllPublicMethod(JoinPoint joinPoint) {
        System.out.println(" beforeAllPublicMethod 111");
    }

    @Around("PointcutConfig.allControllerMethod()")
    public void aroundAllPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(" aroundAllPublicMethod 111");
        pjp.proceed();
    }


}
