package com.fly.jdbc;

import com.fly.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  ${time} ${date}
 * @ Modified By :
 */
public class JdbcTest1 {
    /**
      * @Author: nynui
      * @Description:
      * @Date: 11:48 2018/8/23
      * @Version:
      * @Params:  * @param null
      */
    private static void insertUser(User user){
        Connection connection =null;
        try {
             connection = DBUtils.openConnection();
            String sql = "insert into user(username,age) value(?,?)";
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, user.getUsername());
            statment.setInt(2, user.getAge());
           int i= statment.executeUpdate();
           if(i>0){
               statment.close();
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);
        }
    }

   /**
     * @Author: nynui
     * @Description:
     * @Date: 11:47 2018/8/23
     * @Version:
     * @Params:  * @param null
     */
    private static User  getUser(User user){
        Connection   connection=null;
        User us=null;
        try{

        connection=    DBUtils.openConnection();
        String sql="select id,username,telphone,age from user where id =?";
       PreparedStatement  ps= connection.prepareStatement(sql);
       ps.setInt(1,user.getId());
      ResultSet  rs= ps.executeQuery();
      if (rs.next()){
          us=new User();
         us.setId(rs.getInt(1));
         us.setUsername(rs.getString(2));
      }
      rs.close();
      ps.close();
        }catch (Exception e){}finally {
            DBUtils.close(connection);
        }
     return us;
    }

    public static List<User>  findUser(){
        Connection  connection=null;
        List<User> list=new ArrayList<User>();

        try{
            connection=DBUtils.openConnection();
        PreparedStatement  ps=   connection.prepareStatement("select *  from user");
         ResultSet  rs=   ps.executeQuery();
         while(rs.next()){
             User user=new User();
             user.setId(rs.getInt(1));
             user.setUsername(rs.getString(2));
             user.setAge(rs.getInt(3));
             user.setTelphone(rs.getString(4));
             user.setDesc(rs.getString(5));
             list.add(user);
            }

        }catch (Exception e){}finally {

        }
        return list;

    }

    public static void main(String[] args) {
       User user=new User();
        user.setUsername("zs");
        user.setAge(25);

        JdbcTest1.insertUser(user);
         /* user=new User();
         user.setId(3);
        System.out.print(JdbcTest1.getUser(user));*/
      List<User> list=  JdbcTest1.findUser();
        System.out.println(list.size());
    }
}
