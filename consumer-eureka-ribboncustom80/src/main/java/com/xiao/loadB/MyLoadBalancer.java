package com.xiao.loadB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: ${PROJECT_NAME}
 * @description: ${description}
 * @author: Mr.Wang
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/

@Component
public class MyLoadBalancer implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * @Description: todo
     * @Author: 肖苏伦
     * @Date: 2021-11-29 1:04
     * @Param null:
     * @return: null
     * @Version: 1.0
     **/
    public final int next() {

/*        int next;
        int current;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;

          //在多线程里面更新成功   atomicInteger.compareAndSet(current, next) 为 true
        } while (!atomicInteger.compareAndSet(current, next));

        System.out.println("----------------这个是第几次访问: " + next);
        return next;*/

        for (;;){
            int current=this.atomicInteger.get();
            int next;
            next=current+1;
            if (atomicInteger.compareAndSet(current,next)) {
                return next;
            }
        }

    }
    /*
    * 通过获取index 返回一个服务实例
    * */
    @Override
    public ServiceInstance instance (List < ServiceInstance > instances) {
        int index=next()%instances.size();
        return instances.get(index);
    }
}