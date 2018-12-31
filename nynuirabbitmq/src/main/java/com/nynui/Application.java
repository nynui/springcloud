package com.nynui;

import com.nynui.mq.CallBackSender;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@RestController
@ComponentScan
@SpringBootApplication(scanBasePackages = "com.nynui")
public class Application {
 
	@Autowired
	private CallBackSender sender;
 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		ConnectionFactory  factory= new CachingConnectionFactory("192.168.3.128");
		RabbitTemplate rabbitTemplate=new RabbitTemplate(factory);

	}
 
	 @RequestMapping("/callback")
	public void callbak() {
		sender.send("topic.baqgl.admin.1", "自动测试消息");
	}

	@RequestMapping("/callback2")
	public void callbak2() {
		sender.send("topic.cs.baqgl.admin.1", "手动测试消息");
	}
}
