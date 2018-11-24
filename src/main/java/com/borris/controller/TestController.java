package com.borris.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
@Component("TestController")
@RequestMapping(value="/test")
public class TestController {

    @Transactional
    @RequestMapping(value="/test2/helloWorld2")
    public String helloWorld(HttpServletRequest req, HttpServletResponse res){
        String test = req.getParameter("test");
        return "hello world";
    }
}
