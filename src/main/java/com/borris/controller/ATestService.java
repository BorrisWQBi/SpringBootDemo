package com.borris.controller;

import com.borris.service.TestServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestService")
public class ATestService implements TestServiceInf {
    private TestController tc;

    @Override
    @RequestMapping("/helloService")
    public String helloService(){
        return "hello service";
    }

    @Autowired
    public void setTc(TestController tc) {
        this.tc = tc;
    }
}
