package com.dctest.www.eurekacline;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableSwagger2Doc
@SpringBootApplication
public class EurekaClineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClineApplication.class, args);
    }

}
