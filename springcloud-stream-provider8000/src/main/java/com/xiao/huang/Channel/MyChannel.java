package com.xiao.huang.Channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2022-09-13 1:15
 * @Version : 1.0
 **/
public interface MyChannel {
    String MYOUTPUT = "myoutput";


    /**
     * @return output channel
     */
    @Output(MyChannel.MYOUTPUT)
    MessageChannel myOutput();


}
