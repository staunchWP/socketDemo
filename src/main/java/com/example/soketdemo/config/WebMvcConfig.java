package com.example.soketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 接下来就是要为ws.html提供路径映射
 * @author HuRui
 * create on 2018/3/16 14:50
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("addViewControllers:提供路径映射");
        registry.addViewController("/ws").setViewName("/ws");
    }
}
