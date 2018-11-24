package com.borris.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DruidConfig {
    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new StatViewServlet());
        srb.setName("DruidStatView");
        srb.addInitParameter("resetEnable","true");
        srb.addInitParameter("loginUsername","druidAdmin");
        srb.addInitParameter("loginPassword","1234");
        List<String> urls = new ArrayList<String>();
        urls.add("/druid/*");
        srb.setUrlMappings(urls);
        return srb;
    }

    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();

        return frb;
    }

}
