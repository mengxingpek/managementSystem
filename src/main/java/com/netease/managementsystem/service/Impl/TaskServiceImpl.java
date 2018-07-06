package com.netease.managementsystem.service.Impl;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class TaskServiceImpl {


    @Async
    public void doTaskOne()  {
        for(int i=0;i<=10;i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("doing task 1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Async
    public void doTaskTwo()  {
        for(int i=0;i<=10;i++) {

            System.out.println(Thread.currentThread().getName());
            System.out.println("doing task 2");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }







}
