package com.netease.managementsystem.vo;




import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {


    private Integer id;
    private String username;
    private Integer sex;
    private String address;
    private Date birthday;
    //数据库中得到的密码 已通过md5加密
    private String password;
    private Timestamp createTime;


    public User() {

    }

}
