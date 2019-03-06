package com.dctest.www.eurekacline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @date 2019/2/19 15:13
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@RestController
public class DCController {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public DCController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * 获取配置中心配置文件中的内容
     */
    @Value("${hi}")
    String hi;

    @GetMapping("/dc")
    public String dc(String name) {
        String service = "Service:" + discoveryClient.getServices() + name;
        return service + "----" + hi;
    }
}
