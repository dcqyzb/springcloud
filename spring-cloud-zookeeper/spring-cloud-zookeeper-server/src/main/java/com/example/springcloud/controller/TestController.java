package com.example.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @date 2019/3/1 10:41
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@RestController
public class TestController {

    @GetMapping("/home")
    public String home() {
        return "Hello zookeeper";
    }

}
