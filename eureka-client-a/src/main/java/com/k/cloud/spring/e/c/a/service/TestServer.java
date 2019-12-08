package com.k.cloud.spring.e.c.a.service;

import com.k.cloud.spring.e.c.a.unit.TestUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServer {

    public String sg(){
        TestUnit tu = new TestUnit();
        tu.df();
        return "success";
    }
}
