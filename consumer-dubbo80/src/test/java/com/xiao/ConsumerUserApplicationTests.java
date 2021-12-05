package com.xiao;

import com.zzz.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ConsumerUserApplicationTests {

    @Resource
    UserService userService;
    @Test
    void contextLoads() {
        userService.hello();
    }

}
