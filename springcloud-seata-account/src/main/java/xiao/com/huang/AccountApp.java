package xiao.com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 23:26
 * @Version : 1.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableDiscoveryClient
public class AccountApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountApp.class);
    }
}
