package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xiaosulun
 */ //替换默认轮询算法，不能放在主启动类同一包下
@Configuration
public class Rule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
