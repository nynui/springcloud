package org.nynui.service.A.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ComputerController {
	 private final Logger logger = org.apache.log4j.Logger.getLogger(getClass());
	@Autowired
	private  DiscoveryClient  client;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(int a,int b){
	   ServiceInstance  instance=	client.getLocalServiceInstance();
		int r=a+b;
		 logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		 
		 return "From service-A ,Result is "+r;
	}
	
/*	@RequestMapping(value="testServiceB",method=RequestMethod.GET)
	public String testServiceB(int a,int b){
		RestTemplate   restTemplate=new RestTemplate();
		return restTemplate.getForObject("http://localhost:7075/add?a="+a+"&b="+b, String.class);
	}*/
}
