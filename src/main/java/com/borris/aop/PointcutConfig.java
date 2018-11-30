package com.borris.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PointcutConfig {
    /**
     * 标识符	                                            含义
     * execution()	                                        表达式的主体
     * 第一个“*”符号	                                表示返回值的类型任意
     * com.loongshawn.method.ces	            AOP所切的服务的包名，即，需要进行横切的业务类
     * 包名后面的“..”	                                表示当前包及子包
     * 第二个“*”	表示类名，                           *即所有类
     *   .*(..)	                                                表示任何方法名，括号表示参数，两个点表示任何参数类型
     *
     *   execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     *   execution(<修饰符>? <返回类型> <包，类路径path>?</><方法名> (<参数>) <异常>?)
     * */

    /***
     * com.borris.controller   包下面所有类的所有方法
     * */
    @Pointcut("execution(* com.borris.controller.*.*(..))")
    public void allControllerMethod(){

    }

    /***
     *  spring容器所能管理的bean内的所有public方法
     * */
    @Pointcut("execution( public * * (..))")
    public void allPublicMethod(){

    }

    /***
     * 所有set方法
     * */
    @Pointcut("execution( * set*(..) )")
    public void allSetters(){

    }

    /***
     * 所有public set方法
     * */
    @Pointcut("allPublicMethod() && allSetters()")
    public void allPublicSetters() {

    }

    /***
     * com.borris.dao.TestDao  类 ( 接口亦可 ) 下面所有的所有方法
     * */
    @Pointcut("execution(* com.borris.dao.TestDao.*(..))")
    public void allTestDAOMethod(){

    }

    /***
     * com.borris.dao.TestDao  类 ( 接口亦可 ) 下面所有的protected static方法
     * */
    @Pointcut("execution(protected static * com.borris.dao.TestDao.*(..))")
    public void allTestDAOProtectedStaticMethod(){

    }

    /***
     * com.borris.dao.TestDao  类 ( 接口亦可 ) 下面所有的protected static方法
     * 或者所有public方法
     * */
    @Pointcut("allPublicMethod() || allTestDAOProtectedStaticMethod()")
    public void allTestDAOProtectedStaticOrPublicMethod(){

    }

    /***
     * com.borris.controller包内所有类的方法
     * */
    @Pointcut("within(com.borris.controller.*)")
    public void allWithinMethod(){

    }

    /***
     *  所有使用SelfAnno进行注解的方法/类
     * */
    @Pointcut("@annotation(com.borris.annotation.SelfAnno)")
    public void selfAnnoMethod(){

    }

    /***
     *  所有使用SelfAnno进行注解的方法/类
     * */
    @Pointcut("allPublicMethod() && allControllerMethod() && args(req,res)")
    public void allPublicControllerWithReq(HttpServletRequest req, HttpServletResponse res){

    }
}
