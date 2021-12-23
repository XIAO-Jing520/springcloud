package xiao.com.huang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Milo
 * @Description
 * @Date 2020-05-15 17:06
 **/
@Configuration
@MapperScan({"xiao.com.huang.dao"})
public class MyBatisConfig {
}