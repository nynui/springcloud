package com.fly.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  ${time} ${date}
 * @ Modified By :
 */
public class DBUtils {

    private static String driver ;//连接数据库
    /**
     * url
     */
    private static String url;

    private static String username;

    private static String password;

    static{
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/nynui";
        username="root";
        password="123456";
    }

    public static Connection openConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
