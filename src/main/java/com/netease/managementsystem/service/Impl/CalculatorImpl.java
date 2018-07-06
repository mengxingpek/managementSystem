package com.netease.managementsystem.service.Impl;


import com.netease.managementsystem.service.Calculator;

/**
 * @Author mengxing
 * @Date 2018/7/5 下午2:16
 */
public class CalculatorImpl implements Calculator {



    @Override
    public int add(int a, int b) {
        System.out.println("doing add() ");
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        System.out.println("doing minus() ");
        return a-b;
    }
}
