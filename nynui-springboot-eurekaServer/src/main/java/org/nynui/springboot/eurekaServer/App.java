package org.nynui.springboot.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
