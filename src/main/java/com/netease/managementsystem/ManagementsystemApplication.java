package com.netease.managementsystem;

import com.netease.managementsystem.service.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.TimeUnit;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableAsync
public class ManagementsystemApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ManagementsystemApplication.class, args);


        context.getBean(Task.class).doTaskOne();
        context.getBean(Task.class).doTaskTwo();
        for(int i=0;i<=10;i++) {
            TimeUnit.MICROSECONDS.sleep(1);
            System.out.println("-------------------");
        }

        context.close();

    }
}
