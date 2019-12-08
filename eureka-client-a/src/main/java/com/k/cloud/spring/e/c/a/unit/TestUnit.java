package com.k.cloud.spring.e.c.a.unit;

import com.k.cloud.spring.e.c.a.config.PayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TestUnit {

    @Autowired
    PayConfig payConfig;

    public void df(){
        if(payConfig != null){
            System.out.println("内容-" + payConfig.getZf());
        }
    }
}
