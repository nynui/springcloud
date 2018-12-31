package com.nynui.model;

import java.io.Serializable;
import java.util.Date;
/**
  * @Author: nynui
  * @Description:
  * @Date: 17:27 2018/8/31
  * @Version:
  * @Params:  * @param null
  */
public class TokenData implements Serializable {
    private static final long serialVersionUID = 9163738221440903222L;

    /**
     * accessToken存进Redis中的前缀
     */
    public static final String REDIS_KEY_PREFIX = "userToken";
    
    /**
     * token
     */
    private String accessToken;

    /**
     * ip
     */
    private String ip;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 请求开始时间
     */
    private Date startTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
