package com.example.heip_d.com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//新增加一个类用来添加虚拟路径映射
@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\run\\images\\";
        //       /images/**是对应resource下工程目录
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+path);
        String path1 = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\run\\images\\zf\\";
        //       /images/**是对应resource下工程目录
        registry.addResourceHandler("/zf/**").addResourceLocations("file:"+path1);
    }
}
