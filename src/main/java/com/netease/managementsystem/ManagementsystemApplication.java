package com.netease.managementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ManagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementsystemApplication.class, args);
    }
}
