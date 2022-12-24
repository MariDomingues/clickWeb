package com.click;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClickApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickApplication.class, args);
    }
}
