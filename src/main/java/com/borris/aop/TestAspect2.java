package com.borris.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class TestAspect2 {
    @Before("PointcutConfig.allControllerMethod()")
    public void beforeAllPublicMethod2() {
        System.out.println(" beforeAllPublicMethod 222");
    }
}
