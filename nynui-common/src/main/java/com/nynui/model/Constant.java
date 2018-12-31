package com.nynui.model;
/**
  * @Author: nynui
  * @Description:
  * @Date: 17:28 2018/8/31
  * @Version: 
  * @Params:  * @param null
  */
public class Constant {
    /**
     * 系统
     */
    public static final String SYSTEM = "system";
    
    /**
     * 用户名
     */
    public static final String USER_NAME = "userName";

    /**
     * token
     */
    public static final String ACCESS_TOKEN = "Authorization";

    /**
     * IP
     */
    public static final String IP = "ip";

    /**
     * 系统用户IP
     */
    public static final String SYSTEM_IP = "0.0.0.1";

    public static String getSYSTEM() {
        return SYSTEM;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getAccessToken() {
        return ACCESS_TOKEN;
    }

    public static String getIP() {
        return IP;
    }

    public static String getSystemIp() {
        return SYSTEM_IP;
    }
}
