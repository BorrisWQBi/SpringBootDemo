package com.borris.dao;

import com.borris.persist.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class TestDao {

    @Autowired
    private UserMapper userMapper;

    public List<Map<String,Object>> getAll(){
        return userMapper.getUserList();
    }

}
