package com.xiao.huang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-08 1:39
 * @Version : 1.0
 **/
//刷新
@RefreshScope
@RestController
public class Controller {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get")
    public String get() {
        return configInfo;
    }
}
