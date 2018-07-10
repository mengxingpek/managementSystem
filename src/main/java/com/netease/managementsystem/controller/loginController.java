package com.netease.managementsystem.controller;


import com.netease.managementsystem.dal.db.dao.UserMapper;
import com.netease.managementsystem.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class loginController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("mengxing hello");
        return  "index";

    }


    @RequestMapping(value = "/logout")
    public String logout() {
        System.out.println("logout");
        return "mengxing logout";
    }





}
