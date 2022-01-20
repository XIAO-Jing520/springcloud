package com.xiao.huang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //去除广告
    @Bean
    public FilterRegistrationBean removeDruidAdFilter() throws IOException {

        // 获取common.js内容
        String text = Utils.readFromResource("support/http/resources/js/common.js");
        // 屏蔽 this.buildFooter(); 直接替换为空字符串,让js没机会调用
        final String newJs = text.replace("this.buildFooter();", "");
        // 新建一个过滤器注册器对象
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        // 注册common.js文件的过滤器
        registration.addUrlPatterns("/druid/js/common.js");
        // 添加一个匿名的过滤器对象,并把改造过的common.js文件内容写入到浏览器
        registration.setFilter((servletRequest, servletResponse, filterChain) -> {
            // 重置缓冲区，响应头不会被重置
            servletResponse.resetBuffer();
            // 把改造过的common.js文件内容写入到浏览器
            servletResponse.getWriter().write(newJs);
        });
        return registration;

    }

    /**
     * 配置一个druid的监控
     * 1、配置一个druid的后台  管理servlet
     * 2、配置一个druid的filter
     */
    /*//1、配置一个druid的后台  管理servlet
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
    }*/
}