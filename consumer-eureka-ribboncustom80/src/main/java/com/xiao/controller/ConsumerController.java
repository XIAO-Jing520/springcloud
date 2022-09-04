package com.xiao.controller;

import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import com.xiao.loadB.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author xiaosulun
 */
@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ILoadBalancer practiceLoad;

    @Resource
    private DiscoveryClient discoveryClient;

//    public static String URL="http://127.0.0.1:8001";


    //提供者是集群的话不能写死url
    public static String URL = "http://PROVIDER-ORDER-EUREKA";

    //获取端口号
    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {

        log.info("端口-----------------------serverPort = " + serverPort);
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Integer id) {

        log.info("端口-----------------------serverPort = " + serverPort);
        return restTemplate.getForObject(URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/lb")
    public String lb() {

        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-ORDER-EUREKA");
        for (ServiceInstance instance : instances) {
            System.out.println("instance.getHost() = " + instance.getHost());
            System.out.println("instance.getMetadata() = " + instance.getMetadata());
            System.out.println("instance.getUri() = " + instance.getUri());
            System.out.println("instance.getPort() = " + instance.getPort());
            System.out.println("-------------------------------------");
        }
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance instance = practiceLoad.instance(instances);
        //获取 该服务主机的 url
        URI uri = instance.getUri();
        System.out.println("uri = " + uri);

        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

    @GetMapping("/discovery")
    public Object discovery() {

        //获取注册时的服务名
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            System.out.println("service = " + service);
        }
        //
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-ORDER-EUREKA");

        for (ServiceInstance instance : instances) {
            System.out.println("instance.getHost() = " + instance.getHost());
            System.out.println("instance.getMetadata() = " + instance.getMetadata());
            System.out.println("instance.getUri() = " + instance.getUri());
            System.out.println("instance.getPort() = " + instance.getPort());
            System.out.println("-------------------------------------");
        }

        return "啥也没有";
    }
}
