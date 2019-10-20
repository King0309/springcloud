package com.k.cloud.spring.e.c.a.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @RequestMapping(value = "/order")
    public Callable<String> orders(){
        Callable<String> result = () -> {
            System.out.println("子线程");
            Thread.sleep(2000);
            System.out.println("子线程-");
            return "成功";
        };
        System.out.println("主线程");
        return result;
    }
}
