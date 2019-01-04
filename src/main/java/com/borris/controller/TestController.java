package com.borris.controller;

import com.borris.dao.TestDao;
import com.borris.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/test")
public class TestController {

    private TestDao testDao;

    //    private TestServiceInf testServiceInf;
//    private ATestService ATestService;

    @RequestMapping(value = "/test2/helloWorld2")
    public List<User> helloWorld(HttpServletRequest req, HttpServletResponse res) {
        List<User> list = testDao.getAllUser();
        return list;
    }

//    @RequestMapping("/helloService")
//    public String helloService() {
//        return ATestService.helloService();
//    }

    @Autowired
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }


//    @Autowired
//    public void setATestService(ATestService ATestService) {
//        this.ATestService = ATestService;
//    }

//    @Autowired
//    public void setTestServiceInf(TestServiceInf testServiceInf) {
//        this.testServiceInf = testServiceInf;
//    }
}
