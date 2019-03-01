package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudZookeeperClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZookeeperClientApplication.class, args);
    }

}
