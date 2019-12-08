package com.k.cloud.spring.e.c.a.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pays")
public class PayConfig {

    private String zf;

    public String getZf() {
        return zf;
    }

    public void setZf(String zf) {
        this.zf = zf;
    }
}
