package com.xiao.loadB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2022-09-04 21:10
 * @Version : 1.0
 **/

@Component
public class PracticeLoad implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(1);


    public int getIndex() {
        for (; ; ) {
            int current = atomicInteger.get();
            int next = current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {


        int index = this.getIndex() % 2;

        return instances.get(index);
    }
}
