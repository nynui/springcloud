package com.nynui.service;

import com.nynui.model.Account;

import java.util.List;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  19:02 2018/8/30
 * @ Modified By :
 */
public interface AccountService {

    public void addAccount(String name,int intMoney);

    List<Account> queryAccount(String name);

    int updateAccount(String name,int money);
}
