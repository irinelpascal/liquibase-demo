package com.example.liquibasedemo;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class LiquibaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquibaseDemoApplication.class, args);
    }
}
