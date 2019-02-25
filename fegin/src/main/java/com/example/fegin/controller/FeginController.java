package com.example.fegin.controller;

import com.example.fegin.service.FeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @date 2019/2/21 11:19
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@RestController
public class FeginController {

    private final FeginService feginService;

    @Autowired
    public FeginController(FeginService feginService) {
        this.feginService = feginService;
    }

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return feginService.dc(name);
    }
}
