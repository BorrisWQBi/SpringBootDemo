package com.borris.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    /**
     * 标识符	含义
     * execution()	                                表达式的主体
     * 第一个“*”符号	                        表示返回值的类型任意
     * com.loongshawn.method.ces	    AOP所切的服务的包名，即，需要进行横切的业务类
     * 包名后面的“..”	                        表示当前包及子包
     * 第二个“*”	表示类名，                 *即所有类
     *   .*(..)	                                        表示任何方法名，括号表示参数，两个点表示任何参数类型
     *
     *   execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     *   execution(<修饰符>? <返回类型> <包，类路径path>?</><方法名> (<参数>) <异常>?)
     * */
    @Pointcut("execution(* com.borris.controller.*(..))")
    public void testInterseptor(){

    }
}
