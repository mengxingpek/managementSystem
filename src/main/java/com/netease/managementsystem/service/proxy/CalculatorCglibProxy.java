package com.netease.managementsystem.service.proxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author mengxing
 * @Date 2018/7/5 下午3:44
 */


public class CalculatorCglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before " +method);
        Object ret = methodProxy.invokeSuper(o,objects);
        System.out.println("after " + method);
        return  ret;


    }
}
