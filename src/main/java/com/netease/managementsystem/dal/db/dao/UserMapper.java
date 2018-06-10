package com.netease.managementsystem.dal.db.dao;

import com.netease.managementsystem.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("select * from people")
    List<User> getAllUsers();

    @Select("select * from people where id = #{id}")
    User getUserByID(int id) ;


}

