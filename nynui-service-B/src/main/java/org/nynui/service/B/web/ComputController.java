package org.nynui.service.B.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputController {
	
	private final Logger  logger=Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient  client;

	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(int a,int b){
	ServiceInstance  instance=client.getLocalServiceInstance();
		int result=a+b;
		logger.info("/add, host:"+instance+",service_id : "+instance.getServiceId()+" ,result:  "+result);
		return "From service-B,result  is  "+result+",port:"+instance.getPort();
	}
}
