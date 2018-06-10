package com.netease.managementsystem.vo;




import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {


    private Integer id;
    private String username;
    private Integer sex;
    private String address;
    private Date birthday;


    public User() {

    }

}
