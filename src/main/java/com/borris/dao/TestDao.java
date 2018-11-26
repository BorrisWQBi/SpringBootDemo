package com.borris.dao;

import com.borris.persist.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TestDao {

    @Autowired
    private UserMapper userMapper;

    public List<Map<String,String>> getAll(){
        return userMapper.getUserList();
    }

}
