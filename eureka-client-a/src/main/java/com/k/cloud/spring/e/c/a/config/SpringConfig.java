package com.k.cloud.spring.e.c.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class SpringConfig {
    /**
     * 程序中使用 @value获取yml配置文件属性
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer pp = new PropertySourcesPlaceholderConfigurer();
        pp.setIgnoreUnresolvablePlaceholders(true);
        return pp;
    }


}
