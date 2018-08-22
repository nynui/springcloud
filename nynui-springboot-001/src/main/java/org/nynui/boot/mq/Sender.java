package org.nynui.boot.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/***
 * 生产者生产消息
 * @author Administrator
 *
 */
@Component
public class Sender {

	@Autowired
	private AmqpTemplate   rabbitTemplate;
	
	public void send(){
		
		rabbitTemplate.convertAndSend("first","test rabbitmq message");
	}
	
}
