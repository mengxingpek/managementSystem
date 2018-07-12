package com.netease.managementsystem.dal.db.dao;

import com.netease.managementsystem.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id}")
    User getUserByID(int id);

    @Select("select * from user where username = #{userName}")
    User getUserByName(String userName);


    @Insert({
            "insert into user ( username, ",
            "sex, address, ",
            "birthday ,",
            "password ," ,
            "create_time )" ,
            "values (#{username,jdbcType=VARCHAR}, #{sex,jdbcType=INTEGER}, ",
            "#{address,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, #{password,jdbcType=VARCHAR}," ,
            "#{createTime,jdbcType=TIMESTAMP} ) "
    })
    void insertUser(User user);


}

