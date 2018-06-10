package com.netease.managementsystem.controller;


import com.netease.managementsystem.dal.db.dao.UserMapper;
import com.netease.managementsystem.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public User getUserByID(@PathVariable("id") int id) {
        User aUser = userMapper.getUserByID(id);
        return aUser;


    }


}
