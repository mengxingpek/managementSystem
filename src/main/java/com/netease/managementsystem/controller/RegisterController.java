package com.netease.managementsystem.controller;

import com.netease.managementsystem.dal.db.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class RegisterController {


    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/register")
    public String register() {
        System.out.println("mengxing hello");
        return  "register";

    }















}
