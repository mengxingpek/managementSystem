package com.netease.managementsystem.service.Impl;


import com.netease.managementsystem.vo.User;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @Author mengxing
 * @Date 2018/7/9 下午2:19
 */

@Service
public class ThreadLocalVarPrintTask {

    // 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<User> seqNum = new ThreadLocal<User>() {
        public User initialValue() {
            User user = new User();
            user.setId(1);
            user.setAddress("北京市房山区");
            user.setUsername("mengxing");
            return user;

        }
    };

    // 获取下一个序列值
    public int getUserID() {

        User user = seqNum.get();
        user.setId( user.getId()+1  );


        return seqNum.get().getId();
    }

    public static void main(String[] args) {
        ThreadLocalVarPrintTask sn = new ThreadLocalVarPrintTask();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private ThreadLocalVarPrintTask sn;

        public TestClient(ThreadLocalVarPrintTask sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                // 每个线程打出3个序列值
                // 说明哪怕ThreadLocal是可变对象 也是各线程独立的
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getUserID() + "]");
            }
        }
    }




}
