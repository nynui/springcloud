package com.nynui.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  16:27 2018/12/24
 * @ Modified By :
 */
public class Config {
/*

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        // 开启事务模式
        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }*/
}
