package com.nynui.service.imple;

import com.nynui.service.AccountService;
import com.nynui.service.UserSerivce;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
  * @Author: nynui
  * @Description:
  * @Date: 19:10 2018/8/30
  * @Version: 
  * @Params:  * @param null
  */
  
@Service
public class UserSerivceImpl implements UserSerivce {


    @Autowired
    AccountService accountService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(String name) {
        jdbcTemplate.update("INSERT INTO `user` (userName) VALUES(?)", name);
        //((UserSerivce) AopContext.currentProxy()).addAccount(name, 10000);
       accountService.addAccount(name,10000);
        // 人为报错
        int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addAccount(String name, int initMoney) {
        String accountid = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("insert INTO account (accountName,user,money) VALUES (?,?,?)", accountid, name, initMoney);
    }



}