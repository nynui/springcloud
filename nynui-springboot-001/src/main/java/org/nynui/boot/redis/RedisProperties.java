package org.nynui.boot.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * 
 * @Description: 
 * 
 * @ClassName: RedisProperties
 * @Author: Administrator
 * @Date: 2018/12/27
 * @Version: 0.0.1
 */

//@Component
//@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
 
    private int    expireSeconds;
    private String clusterNodes;
    private String password;
    private int    commandTimeout;

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }
}