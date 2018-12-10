package com.borris.controller;

import com.borris.dao.TestDao;
import com.borris.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="/test")
public class TestController {

    @Autowired
    TestDao testDao;

    @RequestMapping(value="/test2/helloWorld2",method=RequestMethod.GET)
    public List<User> helloWorld(HttpServletRequest req, HttpServletResponse res){
        return testDao.getAllUser();
    }
}
