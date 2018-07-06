package com.netease.managementsystem.controller;


import com.netease.managementsystem.service.Calculator;
import com.netease.managementsystem.service.Impl.CalculatorImpl;
import com.netease.managementsystem.service.proxy.CalculatorCglibProxy;
import com.netease.managementsystem.service.proxy.CalculatorProxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * @Author mengxing
 * @Date 2018/7/5 下午2:28
 */

@RestController
public class proxyController {

    @RequestMapping(value = "/dynamicProxy", method = RequestMethod.GET)
    public void dynamicProxy() {

        CalculatorImpl calculatorImpl = new CalculatorImpl();
        CalculatorProxy calculatorProxy = new CalculatorProxy(calculatorImpl);
        Calculator calculator = (Calculator) Proxy.newProxyInstance(calculatorImpl.getClass().getClassLoader(), calculatorImpl.getClass().getInterfaces(), calculatorProxy);
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.minus(1, 2));
        System.out.println(calculator.toString());

    }



    @RequestMapping(value = "/cglibProxy", method = RequestMethod.GET)
    public void cglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalculatorImpl.class);
        enhancer.setCallback(new CalculatorCglibProxy());
        Calculator calculator = (Calculator) enhancer.create();
        System.out.println(calculator.add(1,2));
//        System.out.println(calculator.minus(1,2));
//        System.out.println(calculator.toString() );
//        System.out.println(calculator.hashCode());



    }




}
