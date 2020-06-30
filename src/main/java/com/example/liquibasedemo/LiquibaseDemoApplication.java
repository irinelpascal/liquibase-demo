package com.example.liquibasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LiquibaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquibaseDemoApplication.class, args);
    }

}
