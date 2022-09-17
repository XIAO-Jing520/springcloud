package com.xiao.huang.Channel;

import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * @author xiaosulun
 */
@Component
public class MyPartitionKeyStrategy implements PartitionKeyExtractorStrategy {
    @Override
    public Object extractKey(Message<?> message) {

//        com.microservice.stream.controller.Message sendMsg = (com.microservice.stream.controller.Message) message.getPayload();

//        Random random =new Random();
//
//        final int r = random.nextInt(2);
//
//        System.out.println("r:" + r);

        return 0;
    }
}