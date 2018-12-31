package com.nynui.mq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
  * @Description
 * @Data: Create  in  16:46 2018/12/24
 * @ Modified By :
 */
@Component
public class ReceUnAck {


    @RabbitListener(queues = RabbitConfig.QUEUE_NAMECS,containerFactory = "simpleRabbitListenerContainerFactory")
    public void recevie(String data, org.springframework.amqp.core.Message message, Channel channel){

        System.out.println("手动提交"+data);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
