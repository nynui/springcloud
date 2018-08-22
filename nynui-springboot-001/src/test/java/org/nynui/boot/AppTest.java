package org.nynui.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nynui.boot.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=App.class)
@RunWith(SpringRunner.class)
public class AppTest {

	@Autowired
	private  Config config;
	@Autowired
	private Sender sender;
	
	@Test
	public void Test(){
		config.init();
	}
	
	@Test
	public void testRabbitMq(){
		sender.send();
	}
	
	
}
