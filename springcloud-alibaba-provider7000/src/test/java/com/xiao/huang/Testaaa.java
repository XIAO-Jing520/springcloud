package com.xiao.huang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description :
 * 1、@SpringbootTest @RunWith(SpringJUnit4ClassRunner.class) 让测试在Spring容器环境下执行测试
 * 2、@Transactional 开启事务，支持工程代码中配置了的注解式事务
 * 3、@Rollback 设置测试后回滚，默认属性为true，即回滚。保证测试完后，自测数据不污染数据库，从而保证测试案例可以重复执行。
 * @Author : 肖苏伦
 * @Date : 2022-01-21 0:25
 * @Version : 1.0
 **/
@SpringBootTest
@Transactional
@Rollback
@RunWith(SpringRunner.class)
public class Testaaa {

    @Resource
    DataSource dataSource;
    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    public void testa() throws SQLException {


        System.out.println("dataSource = " + dataSource.getClass());

        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());

        Integer i=jdbcTemplate.queryForObject("select count(*) from tb_payment" ,Integer.class);

        System.out.println("i = " + i);

    }
}
