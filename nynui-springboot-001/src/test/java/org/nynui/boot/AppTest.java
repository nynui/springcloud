package org.nynui.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nynui.boot.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
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
	@Autowired
	private RedisTemplate redisTemplate;

/*
	@Autowired
	private JedisCluster jedisCluster;
*/

	@Test
	public void TestReidsClient(){


	/*	//RedisAtomicLong entityIdCounter = new RedisAtomicLong("abc", redisTemplate.getConnectionFactory());
		for (int i = 0; i < 100000; i++) {
			try{
				//Long increment = entityIdCounter.getAndIncrement();
			Long increment=	jedisCluster.incr("abc");
				System.out.println(increment);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	}

	@Test
	public void TestReidsCluster(){


		RedisAtomicLong entityIdCounter = new RedisAtomicLong("abc", redisTemplate.getConnectionFactory());
		for (int i = 0; i < 100000; i++) {
			try{
				Long increment = entityIdCounter.getAndIncrement();

				System.out.println(increment);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void testRedisString(){

	}

	
}
