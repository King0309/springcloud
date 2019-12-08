package com.k.cloud.spring.e.c.a.controller;

import com.alibaba.fastjson.JSONObject;
import com.k.cloud.spring.e.c.a.service.TestServer;
import com.k.json.JsonUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @Value("${spring.profiles.active}")
    private String profiles;

    @Autowired
    TestServer ts;

    @RequestMapping(value = "/uni/post/data", method = RequestMethod.POST, consumes = {"application/json"})
    public String dataJsonPost(@RequestBody String param){
        System.out.println(param);
        return param;
    }

    @RequestMapping(value = "/uni/data")
    public String dataJson(String name, Integer age, Integer sex){
        System.out.println("name = " + name + " age = " + age + " sex = " + sex);
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("age", String.valueOf(age));
        map.put("sex", String.valueOf(sex));
        String jsonStr = JSONObject.toJSONString(map);
        return jsonStr;
    }

    @RequestMapping(value = "/order")
    public Callable<String> orders(){
        System.out.println(profiles);
        ts.sg();
        Map<String, Object> map = new HashMap<>();
        map.put("a", "abc");
        String json = JsonUntils.mapToJson(map);
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
