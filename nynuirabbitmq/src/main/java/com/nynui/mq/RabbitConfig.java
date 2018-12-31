package com.nynui.mq;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
 
@Configuration
public class RabbitConfig {


	final static String EXCHANGE_NAME = "amq.topic";
	final static String QUEUE_NAMECS = "topic.cs.baqgl.*.*";
	final static String QUEUE_NAME = "topic.baqgl.*.*";
	final static String ROUTING_KEY = "topic.baqgl.#";

	@Bean
	/** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMandatory(true);
		// 开启事务模式
		rabbitTemplate.setChannelTransacted(true);
		return rabbitTemplate;
	}

 
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
 
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}

	@Bean
	public Queue queuecs() {
		return new Queue(QUEUE_NAMECS, true);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY);
	}
	@Bean
	public Binding csbinding() {
		return BindingBuilder.bind(queuecs()).to(exchange()).with(QUEUE_NAMECS);
	}

/*
	@Bean(name="unAckFactory")
	public SimpleRabbitListenerContainerFactory FirstFactory(
			SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory
	) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}
*/

	@Bean(name="simpleRabbitListenerContainerFactory")
	public SimpleRabbitListenerContainerFactory secondFactory(
			SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory
	) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		configurer.configure(factory, connectionFactory);
		return factory;
	}

}
