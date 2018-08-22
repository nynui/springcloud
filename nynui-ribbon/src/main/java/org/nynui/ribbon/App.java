package org.nynui.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Hello world!
 *
 */

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class App 
{
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
