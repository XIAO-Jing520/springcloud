package xiao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerConsul80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsul80.class);
    }

    @Bean
    @LoadBalanced      //注解赋予RestTemplate负载均衡的能力
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
