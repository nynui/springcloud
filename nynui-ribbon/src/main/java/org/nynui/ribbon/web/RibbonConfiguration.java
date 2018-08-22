package org.nynui.ribbon.web;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RibbonConfiguration {

	   @Bean
	   @LoadBalanced  
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	
	@Bean
	public IRule ribbonRule() {
		//new RoundRobinRule();//轮询
		//new  BestAvailableRule();//最少并发策略
	    return new RandomRule();//随机
	}
}
