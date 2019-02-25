package com.example.fegin.hystric;

import com.example.fegin.service.FeginService;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @date 2019/2/21 11:43
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: mitesofor </p>
 */
@Component
public class FeginToHystric implements FeginService {

    @Override
    public String dc(String name) {
        return "sorry" + name;
    }
}
