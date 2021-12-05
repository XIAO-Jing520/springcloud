package com.zzz.controller;
import com.zzz.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestDubboController {

    @Resource
    private UserService userService;

    @GetMapping("/aa")
    public String test() {

        System.out.println("---------------------------------------");
        userService.hello();
        return "success";
    }
}
