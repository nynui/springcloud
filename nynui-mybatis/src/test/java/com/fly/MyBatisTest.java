package com.fly;

import com.fly.mapper.UserMapper;
import com.fly.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
  * @Author: nynui
  * @Description:
  * @Date: 17:12 2018/8/23
  * @Version: 
  * @Params:  * @param null
  */

public class MyBatisTest {
  Logger  logger= LoggerFactory.getLogger(MyBatisTest.class);
    private SqlSession  getSession(){
        String ressource="myBatis-config.xml";
        SqlSession  session=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(ressource);
            SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
           session= sqlSessionFactory.openSession();

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return session;
    }

    private  boolean claoseSession(SqlSession session){
        try{
            if(session!=null){
                session.close();
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Test
    public void selectUser(){
        SqlSession  sqlSession=getSession();
        UserMapper  userMapper= sqlSession.getMapper(UserMapper.class);
       User user=userMapper.selectUser(3);
        logger.info(user.toString());
    }

}
