package com.fasttrackit.imcapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
@SpringBootApplication

public class IMCApplication {

    public static void main(String[] args) {
        SpringApplication.run(IMCApplication.class, args);
    }

}
