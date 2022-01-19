package com.xiao.huang.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.Filter;
import javax.sql.DataSource;
 
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
 
@Configuration
public class DruidConfig {
 
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    /**
     * 配置一个druid的监控
     * 1、配置一个druid的后台  管理servlet
     * 2、配置一个druid的filter
     */
    //1、配置一个druid的后台  管理servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        //注意，请求时 /druid/*
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParm= new HashMap<>();
        //登陆页面账户与密码
        initParm.put(ResourceServlet.PARAM_NAME_USERNAME,"root");
        initParm.put(ResourceServlet.PARAM_NAME_PASSWORD,"123456");
        //监控后台 允许ip
        initParm.put(ResourceServlet.PARAM_NAME_ALLOW,"127.0.0.1");
        //黑名单
        initParm.put(ResourceServlet.PARAM_NAME_DENY,"192.188.55.2");
 
        bean.setInitParameters(initParm);
        return bean;
    }
        //    2、配置一个druid的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
 
        Map<String, String> initPrams = new HashMap<>();
        initPrams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        bean.setInitParameters(initPrams);
 
        //设置拦截器请求
        bean.setUrlPatterns(Arrays.asList("/"));
        return bean;
    }
}