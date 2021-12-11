package com.xiao.huang.service.impl;


import com.xiao.huang.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Milo
 * @Description
 * @Date 2020-05-14 13:16
 **/
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider
{
    @Resource
    private MessageChannel outputProvider; // 定义消息发送管道

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        //主要实现发送
        outputProvider.send(MessageBuilder.withPayload(serial).build());

        System.out.println("*****serial: "+serial);
        return null;
    }
}
