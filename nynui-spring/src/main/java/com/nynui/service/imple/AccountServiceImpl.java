package com.nynui.service.imple;

import com.nynui.model.Account;
import com.nynui.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  19:04 2018/8/30
 * @ Modified By :
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    JdbcTemplate  jdbcTemplate;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addAccount(String name, int intMoney) {
        String accountid = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("insert into account (accountName,user,money) VALUES (?,?,?)",accountid,name,intMoney);

    }

    @Override
    @Transactional
    public List<Account> queryAccount(String name) {
        List<Account> list = jdbcTemplate.queryForList("SELECT * from account where user=?", Account.class, name);
        Arrays.toString(list.toArray());
        return list;
    }

    @Override
    @Transactional
    public int updateAccount(String name, int money) {
        return jdbcTemplate.update("SELECT * from account set money=money+? where user=?", money, name);
    }
}
