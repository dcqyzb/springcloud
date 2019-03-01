package com.example.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mr.Deng
 * @date 2019/3/1 10:49
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@Service
@FeignClient("spring-cloud-zookeeper-server")
public interface TestI {

    @GetMapping("/home")
    String hi();
}
