package com.borris.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
public class TestAspect2 {
    @Before("PointcutConfig.allControllerMethod()")
    public void beforeAllPublicMethod2() {
        System.out.println(" beforeAllPublicMethod 222");
    }
    @Around("PointcutConfig.allControllerMethod()")
    public Object aroundAllPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(" aroundAllPublicMethod 222");
        return pjp.proceed();
    }

    @After("PointcutConfig.allControllerMethod()")
    public void afterAllPublicMethod(JoinPoint jp){

    }

    @AfterReturning("PointcutConfig.allControllerMethod()")
    public void afterReturnAllPublicMethod(JoinPoint jp){

    }
    @AfterThrowing("PointcutConfig.allControllerMethod()")
    public void afterThrowingAllPublicMethod(JoinPoint jp){

    }
}
