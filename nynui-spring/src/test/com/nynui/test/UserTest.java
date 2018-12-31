package com.nynui.test;

import com.nynui.service.UserSerivce;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  19:21 2018/8/30
 * @ Modified By :
 */
public class UserTest {

    @Test
    public void createUser() throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-tx.xml");
        UserSerivce service = context.getBean(UserSerivce.class);
        service.createUser("chenfei");
    }

}
