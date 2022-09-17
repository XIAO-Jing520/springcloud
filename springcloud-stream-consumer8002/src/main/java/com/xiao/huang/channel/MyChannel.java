package com.xiao.huang.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2022-09-13 1:15
 * @Version : 1.0
 **/
public interface MyChannel {

    //值默认是rabbitmq 交换机名称
    String MYINPUT = "myinput";

    /**
     * @return output channel
     */
    @Input(MyChannel.MYINPUT)
    SubscribableChannel myIntput();
}
