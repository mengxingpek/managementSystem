package com.netease.managementsystem.controller;


import com.netease.managementsystem.dal.db.dao.UserMapper;
import com.netease.managementsystem.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userMapper.getAllUsers();
        return users;
    }


    @RequestMapping(method = RequestMethod.POST)
    public User insertUser(@RequestParam("name") String name ,
                             @RequestParam("sex") String sex,
                             @RequestParam("address" )String address,
                             @RequestParam("birthday") String birthday) {
        System.out.println("entering insertUser");
        User user = new User();
        user.setAddress(address);
        user.setSex(Integer.parseInt(sex));
        user.setUsername(name);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

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
