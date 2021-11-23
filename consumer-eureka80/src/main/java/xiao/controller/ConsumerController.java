package xiao.controller;

import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

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
}
