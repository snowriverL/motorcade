package com.dorcen.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dorcen.activity.modules.*.mapper")
public class MotorcadeActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorcadeActivityApplication.class, args);
    }

}
