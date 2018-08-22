package org.nynui.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient  loadBalanceClient;
	
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public  String add(int a,int b){
		this.loadBalanceClient.choose("service-B");
		return restTemplate.getForEntity("http://service-B/add?a="+a+"&b="+b, String.class).getBody();
		
	}
}
