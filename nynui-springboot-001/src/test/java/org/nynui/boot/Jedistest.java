package org.nynui.boot;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;

import java.util.*;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  16:12 2018/12/28
 * @ Modified By :
 */
public class Jedistest {

    public   Set<HostAndPort>  init(){
        HostAndPort  port1=new HostAndPort("192.168.3.160",8001);
        HostAndPort  port2=new HostAndPort("192.168.3.160",8002);
        HostAndPort  port3=new HostAndPort("192.168.3.160",8003);
        HostAndPort  port4=new HostAndPort("192.168.3.160",8004);
        HostAndPort  port5=new HostAndPort("192.168.3.160",8005);
        HostAndPort  port6=new HostAndPort("192.168.3.160",8006);
        HostAndPort  port7=new HostAndPort("192.168.3.160",8007);
        HostAndPort  port8=new HostAndPort("192.168.3.160",8008);
        Set<HostAndPort> hostAndPortSet=new HashSet<HostAndPort>();
        hostAndPortSet.add(port1);
        hostAndPortSet.add(port2);
        hostAndPortSet.add(port3);
        hostAndPortSet.add(port4);
        hostAndPortSet.add(port5);
        hostAndPortSet.add(port6);
        hostAndPortSet.add(port7);
        hostAndPortSet.add(port8);
        return hostAndPortSet;
    }
    @Test
    public void TestString(){

        JedisCluster  jedisCluster=new JedisCluster(init());
        String name=jedisCluster.get("name");
        System.out.printf(name);

    }

    /***
     * String  strings  ,stringex
     * @throws Exception
     */
    @Test
    public void TestMString()throws  Exception{

        JedisCluster  jedisCluster=new JedisCluster(init());
       // jedisCluster.mset("name","name zs age 1","23","a");
        //jedisCluster.mset("{test}name","liuling","{test}age","23","{test}qq","476777XXX");
        jedisCluster.mset("{test}name","liuling","{test}age","23","{test}qq","476777XXX");
        String name=jedisCluster.get("{test}name");
        System.out.println(name);
       List list= jedisCluster.mget("{test}name","{test}age");
        System.out.println(list.toString());
        jedisCluster.set("name","cf", SetParams.setParams().px(5));
        System.out.println(jedisCluster.get("name"));
        Thread.sleep(5l);
        System.out.println(jedisCluster.get("name"));

        jedisCluster.setex("name",1,"cf");

        Thread.sleep(1000l);
        System.out.println(jedisCluster.get("name"));
    }

    /***
     * list  rpush  rpop
     */
    @Test
    public void testRedisList(){

        JedisCluster  jedisCluster=new JedisCluster(init());
        jedisCluster.rpush("books","python","java","C#");
        //获取长度
        System.out.println(jedisCluster.llen("books"));
        System.out.println(jedisCluster.lpop("books"));
        System.out.println(jedisCluster.rpop("books"));
    }

    /***
     * list  lpush len  lpop
     */
    @Test
    public void testRedisList2(){
        JedisCluster  jedisCluster=new JedisCluster(init());
        jedisCluster.lpush("books","python","java","C#");
        //获取长度
        System.out.println(jedisCluster.llen("books"));
        System.out.println(jedisCluster.lpop("books"));
        System.out.println(jedisCluster.rpop("books"));

        jedisCluster.del("books");
    }

    /***
     * hashMap
     */
    @Test
    public void testRedisHash(){
        JedisCluster  jedisCluster=new JedisCluster(init());
        Map<String,String> m=new HashMap<String,String>();
        m.put("golang","comcurrency in go");
        m.put("python","python cookbook");
        jedisCluster.hset( "books","java","thiink in java");
        jedisCluster.hset("books",m);
        //获取长度
        System.out.println(jedisCluster.hlen("books"));
        System.out.println(jedisCluster.hgetAll("books"));
        System.out.println(jedisCluster.hget("books","java"));
        jedisCluster.del("books");
        System.out.println(jedisCluster.hlen("books"));
        System.out.println(jedisCluster.exists("books"));
//        jedisCluster.hdel("books");
    }

    @Test
    public void testSet(){
        JedisCluster  jedisCluster=new JedisCluster(init());
        jedisCluster.sadd("books","python");
        jedisCluster.sadd("books","python");
        jedisCluster.sadd("books","java","golang");
        System.out.println(jedisCluster.scard("books"));
        System.out.println(jedisCluster.smembers("books"));
        System.out.println(jedisCluster.spop("books"));
        System.out.println(jedisCluster.spop("books"));
    }





}
