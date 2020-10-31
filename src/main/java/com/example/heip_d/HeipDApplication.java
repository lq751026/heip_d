package com.example.heip_d;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.heip_d.com.example.mapper")
@EnableCaching  //开启缓存
@SpringBootApplication
public class HeipDApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeipDApplication.class, args);
    }

}
