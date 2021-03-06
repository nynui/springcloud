package com.fly;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fly.mapper.UserMapper;
import com.fly.model.User;

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
        String ressource= "mybatis-config.xml";
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
      /*  SqlSession  sqlSession=getSession();
        UserMapper  userMapper= sqlSession.getMapper(UserMapper.class);
        User u=new User();
        u.setUsername("ls");

        User user=userMapper.selectUser(3);
        logger.info(user.toString());*/
    }


    @Test
    public void test() throws IOException {
        SqlSession  sqlSession=getSession();
        UserMapper  userMapper= sqlSession.getMapper(UserMapper.class);
       User user=  userMapper.selectUser(3);
        logger.info("user:{}",user);

    }
    
    @Test
    public void test2() throws IOException {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession sqlSession = sqlSessionFactory.openSession();
      User user = sqlSession.selectOne("com.fly.mapper.UserMapper.selectUser", 3);
      logger.info("user:{}",user);

    }
    

}
