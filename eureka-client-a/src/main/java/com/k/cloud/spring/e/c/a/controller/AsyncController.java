package com.k.cloud.spring.e.c.a.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @Value("${spring.profiles.active}")
    private String profiles;

    @RequestMapping(value = "/order")
    public Callable<String> orders(){
        System.out.println(profiles);
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
