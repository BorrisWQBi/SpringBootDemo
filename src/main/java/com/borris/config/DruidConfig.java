package com.borris.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DruidConfig {
    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Bean("druidServlet")
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new StatViewServlet());
        srb.setName("DruidStatView");
        srb.addInitParameter("resetEnable","true");
        srb.addInitParameter("loginUsername","root");
        srb.addInitParameter("loginPassword","1234");
        List<String> urls = new ArrayList<String>();
        urls.add("/druid/*");
        srb.setUrlMappings(urls);
        return srb;
    }

    @Bean("druidFilter")
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new WebStatFilter());
        frb.setName("DruidWebStatFilter");
        Map<String ,String> initPar = new HashMap<String,String>(3);
        initPar.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        initPar.put("sessionStatMaxCount","1000");
        initPar.put("profileEnable","true");
        frb.setInitParameters(initPar);
        List<String> urls = new ArrayList<String>(1);
        urls.add("/*");
        frb.setUrlPatterns(urls);
        return frb;
    }

    @Bean("druid-stat-interceptor")
    public DruidStatInterceptor druidStatInterceptor(){
        return new DruidStatInterceptor();
    }

//    @Bean("druid-type-proxyCreator")
//    public BeanTypeAutoProxyCreator beanTypeAutoProxyCreator(){
//        BeanTypeAutoProxyCreator btapc = new BeanTypeAutoProxyCreator();
////        beanTypeAutoProxyCreator.setTargetBeanType();
//        btapc.setInterceptorNames(new String[]{"druid-stat-interceptor"});
//        return btapc;
//    }

    @Bean("druid-stat-pointcut")
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut(){
        JdkRegexpMethodPointcut jrmp = new JdkRegexpMethodPointcut();
        jrmp.setPatterns(new String[]{"com.borris.dao.*"});
        return jrmp;
    }

    @Bean("druidAdvisor")
    @Order(3)
    public Advisor druidAdvisor(JdkRegexpMethodPointcut jrmp,DruidStatInterceptor dsi) {
        Advisor adv = new DefaultPointcutAdvisor(jrmp, dsi);
        return adv;
    }

}
