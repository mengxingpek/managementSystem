package com.netease.managementsystem.controller;


import com.netease.managementsystem.service.Impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {


    @Autowired
    TaskServiceImpl asynTaskServiceImpl;




    @RequestMapping(value = "/task1" , method = RequestMethod.GET)
    public void initiateTaskOne() {
        System.out.println("initiateTaskOne");
        asynTaskServiceImpl.doTaskOne();
    }


    @RequestMapping(value = "/task2" , method = RequestMethod.GET)
    public void initiateTaskTwo() {
        System.out.println("initiateTaskTwo");
        asynTaskServiceImpl.doTaskTwo();
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public void initiateTasks() {
        System.out.println("initiateTasks");
        System.out.println(Thread.currentThread().getName());


        for(int i=0;i<6;i++) {

            // 线程池core size 5  max size 10 ， 队列size 5
            // 所以这里创建了12个线程，应该是5个放到core里，5个放到队列里，队列满后再进一步创建2个线程
            //应有7个线程在跑
            asynTaskServiceImpl.doTaskOne();
            asynTaskServiceImpl.doTaskTwo();
        }


        System.out.println("-----------------");
    }





}
