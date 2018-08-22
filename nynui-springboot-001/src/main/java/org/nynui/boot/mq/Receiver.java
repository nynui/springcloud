package org.nynui.boot.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/****\
 * 消费者消费消息
 * @author Administrator
 *
 */
@Component
@RabbitListener(queues="first")
public class Receiver {

	@RabbitHandler
	public void process(String msg){
		System.out.println("receive message:"+msg);
	}
}
