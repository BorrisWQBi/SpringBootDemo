package com.borris.persist.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserMapper {

    @Select("select * from tbl_user")
    List<Map<String,Object>> getUserList();
}
