package com.xiao.loadB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalancer {

    public ServiceInstance instance(  List<ServiceInstance> instances );
}
