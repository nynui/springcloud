package com.nynui.util;

import java.util.HashMap;
import java.util.Map;

public class ContextHolder {
    /***
     * 只能存放临时数据，不能存放静态变量，静态常量
     */
    private static ThreadLocal<Map<String, Object>> contextHolder = new ThreadLocal<>();

    /**
     * 获取上下文数据
     * 
     * @return
     */
    private static Map<String, Object> getData() {
        Map<String, Object> result = contextHolder.get();
        if (result == null) {
            result = new HashMap<>();
            contextHolder.set(result);
        }

        return result;
    }

    /**
     * 获取上下文数据
     * 
     * @return
     */
    public static String getString(String attribute) {
        Object value = getData().get(attribute);
        return value == null ? null : String.valueOf(value);
    }

    /**
     * 清除数据
     */
    public static void clear() {
        contextHolder.remove();
    }
}