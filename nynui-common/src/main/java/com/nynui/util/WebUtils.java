package com.nynui.util;

import javax.servlet.http.HttpServletRequest;

import com.nynui.model.Constant;
import com.nynui.model.TokenData;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
  * @Author: nynui
  * @Description:
  * @Date: 17:27 2018/8/31
  * @Version: 
  * @Params:  * @param null
  */
  
public class WebUtils {
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    /**
     * 判断request是否为ajax请求
     * 
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("content-type") != null
                        && request.getHeader("content-type").indexOf("application/json") > -1))
                || (request.getHeader("X-Requested-With") != null
                        && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1);
    }

    /**
     * 获取request的http状态码
     * 
     * @param request
     * @return
     */
    public static HttpStatus getHttpStatus(HttpServletRequest request) {
        Assert.notNull(request, "HttpServletRequest is reqired not null.");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * l判断url是否忽略验证token
     * 
     * @param url url
     * @return boolean
     */
    public static boolean ignoreToken(String url, String[] ignoreTokenUrls) {
        if (StringUtils.isEmpty(url)) {
            return false;
        }

        if (ArrayUtils.isEmpty(ignoreTokenUrls)) {
            return false;
        }

        for (String ignoreTokenUrl : ignoreTokenUrls) {
            if (ANT_PATH_MATCHER.match(ignoreTokenUrl, url)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 根据web request获取accessToken
     * 
     * @return accessToken
     */
    public static String getAccessToken() {

        HttpServletRequest request = getRequest();
        String accessToken = null;
        if (request != null) {
            accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        }

        // 客户端发的请求, 从原来的请求中获取token
        // token为空时, 从ThreadLocal中获取token
        return StringUtils.isBlank(accessToken) ? ContextHolder.getString(Constant.ACCESS_TOKEN) : accessToken;
    }

    /**
     * 获取ip
     * 
     * @return ip
     */
    public static String getIp() {
        HttpServletRequest request = getRequest();
        String ip = null;
        if (request != null) {
            ip = request.getHeader(Constant.IP);
        }

        // request为空时, 应该为定时任务或者消息处理的逻辑, 从token中拿tokenData中的ip, 即登录ip
        // 这种情况取登录ip没有问题, 因为既然能发消息, 证明当时的请求ip是通过审核的
        if (StringUtils.isBlank(ip)) {
            TokenData tokenData = getTokenData();
            ip = tokenData == null ? null : tokenData.getIp();
        }

        // 客户端发的请求, 从原来的请求中获取ip
        return ip;
    }

    /**
     * 获取当前请求, 在tokenFilter之前就缓存了
     * 
     * @return
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }

        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * 根据web request获取tokenData
     * 
     * @return tokenData
     */
    public static TokenData getTokenData() {
        String accessToken = getAccessToken();
        if (StringUtils.isEmpty(accessToken)) {
            return null;
        }

        return RedisUtil.get(RedisUtil.getJoinKey(TokenData.REDIS_KEY_PREFIX, accessToken), TokenData.class);
    }

    /**
     * 根据web request获取redis 用户名
     * 
     * @return 用户名
     */
    public static String getUserName() {

        HttpServletRequest request = getRequest();
        String userName = null;
        if (request != null) {
            userName = request.getHeader(Constant.USER_NAME);
        }

        // request为空时, 应该为定时任务或者消息处理的逻辑, 从token中拿tokenData中的useName, 即登录userName
        if (StringUtils.isBlank(userName)) {
            TokenData tokenData = getTokenData();
            userName = tokenData == null ? null : tokenData.getUserName();
        }

        return userName;
    }
}
