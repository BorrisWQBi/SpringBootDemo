package com.borris.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Order(2)
public class TestAspect {


    @Before("PointcutConfig.allControllerMethod()")
    public void beforeAllPublicMethod() {
        System.out.println(" beforeAllPublicMethod 111");
    }


}
