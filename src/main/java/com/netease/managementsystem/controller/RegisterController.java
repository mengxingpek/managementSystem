package com.netease.managementsystem.controller;

import com.netease.managementsystem.dal.db.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@Controller
public class RegisterController {


    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register() {
        System.out.println("entering registration");
        return  "register";

    }


    public static void main(String[] args) {
        String[] str = new String[]{"1","2"};

        List<String> strList = Arrays.asList(str);
//        strList.add("mengxing");
        str[0] = "0";

        System.out.println(strList.size());
        for(String s:strList) {
            System.out.println(s);
        }



        System.out.println(testInteger(1));
        System.out.println(testInt(1));

    }


    public static boolean testInteger (Integer num) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
        boolean flag = Arrays.asList(nums).contains(num);
        return flag;
    }

    public static boolean testInt (int num) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        boolean flag = Arrays.asList(nums).contains(num);
        return flag;
    }







}
