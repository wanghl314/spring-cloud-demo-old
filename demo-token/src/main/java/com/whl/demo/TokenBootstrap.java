package com.whl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TokenBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(TokenBootstrap.class, args);
    }

}
