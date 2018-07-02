package com.netease.managementsystem.service;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class Task {


    @Async
    public void doTaskOne() {

        for(int i=0;i<=10;i++) {
            System.out.println("doing task 1");
        }

    }

    @Async
    public void doTaskTwo() {

        for(int i=0;i<=10;i++) {
            System.out.println("doing task 2");
        }
    }







}
