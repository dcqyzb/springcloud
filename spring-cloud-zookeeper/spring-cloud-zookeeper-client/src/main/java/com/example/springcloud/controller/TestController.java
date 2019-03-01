package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @date 2019/3/1 10:42
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@RestController
public class TestController {

    private final TestI testI;

    @Autowired
    public TestController(TestI testI) {
        this.testI = testI;
    }

    @GetMapping("/hi")
    public String hi() {
        return testI.hi();
    }

}
