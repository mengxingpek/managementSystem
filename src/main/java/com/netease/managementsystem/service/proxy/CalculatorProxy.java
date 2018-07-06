package com.netease.managementsystem.service.proxy;


import com.netease.managementsystem.service.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author mengxing
 * @Date 2018/7/5 下午2:25
 */
public class CalculatorProxy implements InvocationHandler {

    //被代理对象
    Object object;

    public CalculatorProxy(Object obj) {
        this.object = obj;

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object ret = method.invoke(object, args);
        System.out.println("after");
        return ret;
    }
}
