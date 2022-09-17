package com.xiao.huang.service.impl;


import com.xiao.huang.Channel.MyChannel;
import com.xiao.huang.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Milo
 * @Description
 * @Date 2020-05-14 13:16
 **/
@Component
// 定义消息的推送管道,表示监听Stream通道功能
@EnableBinding(MyChannel.class)
public class MessageProviderImpl implements IMessageProvider
{
/*    // 定义消息发送管道
    @Qualifier("output")
    @Resource
    private MessageChannel outputProvider;*/
    @Resource
    private MyChannel myChannel;

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        //主要实现发送
//        outputProvider.send(MessageBuilder.withPayload(serial).build());



        myChannel.myOutput().send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }
}
