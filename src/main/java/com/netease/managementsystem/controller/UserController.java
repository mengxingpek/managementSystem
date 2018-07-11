package com.netease.managementsystem.controller;


import com.netease.managementsystem.dal.db.dao.UserMapper;
import com.netease.managementsystem.util.MD5Util;
import com.netease.managementsystem.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserMapper userMapper;





    @RequestMapping(value = "/verify" , method = RequestMethod.POST)
    public String verifyLoginUser(@RequestParam("userName") String name ,
                                @RequestParam("password") String password) {

        User user = userMapper.getUserByName(name);
        if(user == null) {
            return "unregisted";
        } else {
            String decodedPassword = MD5Util.password(user.getPassword());
            if(password == decodedPassword) {
                return "success";
            } else {
                return "wrong password";
            }
        }






    }







    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userMapper.getAllUsers();
        return users;
    }


    @RequestMapping(method = RequestMethod.POST)
    public User insertUser(@RequestParam("name") String name ,
                             @RequestParam("password") String password,
                             @RequestParam("sex") String sex,
                             @RequestParam("address" )String address,
                             @RequestParam("birthday") String birthday) {
        System.out.println("entering insertUser");

        User user = new User();
        user.setAddress(address);
        user.setSex(Integer.parseInt(sex));
        user.setUsername(name);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        user.setPassword(MD5Util.md5(password));
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));

        try {
            Date date = format1.parse(birthday);
            user.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userMapper.insertUser(user);


        return user;

    }



    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public User getUserByID(@PathVariable("id") int id) {
        User aUser = userMapper.getUserByID(id);
        return aUser;
    }









}
