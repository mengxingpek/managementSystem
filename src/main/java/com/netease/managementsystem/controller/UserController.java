package com.netease.managementsystem.controller;


import com.netease.managementsystem.dal.db.dao.UserMapper;
import com.netease.managementsystem.util.MD5Util;
import com.netease.managementsystem.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserMapper userMapper;





    @RequestMapping(value = "/verify" , method = RequestMethod.POST)
    @ResponseBody
    public String verifyLoginUser(@RequestParam("userName") String name ,
                                @RequestParam("password") String password) {
        System.out.println("verifying");
        User user = userMapper.getUserByName(name);
        if(user == null) {
            System.out.println("unregisted");
            return "unregisted";
        } else {
            String codedPassword = MD5Util.password(password);
            if(codedPassword.equals(user.getPassword())) {
                System.out.println("success");
                return "success";
            } else {
                System.out.println("codedPassword " +codedPassword);
                System.out.println("password" + password);
                System.out.println("user.getPassword " + user.getPassword());
                System.out.println("woring passwrpd");
                return "wrong password";
            }
        }






    }







    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userMapper.getAllUsers();
        return users;
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
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
        user.setPassword(MD5Util.password(password));
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
