package huang.service;

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
@EnableBinding(Sink.class)
public class InputMessage {


    @Value("${server.port}")
    public String port;

    @StreamListener(Sink.INPUT)
    public void inputM(Message message) {

        System.out.println(message.getPayload()+"\t   port:  "+port);

    }


}
