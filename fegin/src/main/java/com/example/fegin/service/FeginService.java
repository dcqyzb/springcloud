package com.example.fegin.service;

import com.example.fegin.hystric.FeginToHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mr.Deng
 * @date 2019/2/21 11:17
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@FeignClient(value = "eureka-cline", fallback = FeginToHystric.class)
public interface FeginService {
    @GetMapping("/client/dc")
    String dc(@RequestParam("name") String name);
}
