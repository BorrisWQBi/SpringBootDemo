package com.borris.dao;

import com.borris.mapper.UserMapper;
import com.borris.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class TestDao {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.selectAllUser();
    }

}
