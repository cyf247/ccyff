package com.bs.mybs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.bs.mybs")
@MapperScan(basePackages = "com.bs.mybs.dao")
public class MybsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybsApplication.class, args);
    }

}
