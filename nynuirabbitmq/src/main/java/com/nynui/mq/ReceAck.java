package com.nynui.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  17:44 2018/12/24
 * @ Modified By :
 */
@Component
public class ReceAck {


    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void recevie(String data, org.springframework.amqp.core.Message message, Channel channel){
        System.out.println("自动提交："+data);


    }


}
