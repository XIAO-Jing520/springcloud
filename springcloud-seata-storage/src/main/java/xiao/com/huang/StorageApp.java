package xiao.com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 2:06
 * @Version : 1.0
 **/
@EnableDiscoveryClient
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@SpringBootApplication
public class StorageApp {
    public static void main(String[] args) {
        SpringApplication.run(StorageApp.class);
    }
}
