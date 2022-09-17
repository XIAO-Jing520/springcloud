package huang.service;

import huang.Channel.MyChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-10 0:48
 * @Version : 1.0
 **/
@Component
//监听Sink类中名为input的输入通道：
@EnableBinding(MyChannel.class)
public class InputMessage {


    @Value("${server.port}")
    public String port;

    /**
     * @description: 监听rabbitmq的消息，具体什么队列，什么topic，通过配置信息application获取
     * @author: xiaosulun
     * @date: 2022-09-12 2:56
     */
    @StreamListener(MyChannel.MYINPUT)
    public void inputM(Message message) {

        System.out.println(message.getPayload()+"\t   port:  "+port);

    }


}
