package com.example.configclinet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @date 2019/2/22 16:41
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${democonfigclient.message}")
    String message;

    @GetMapping("/ss")
    public String ss() {
        return message;
    }
}
