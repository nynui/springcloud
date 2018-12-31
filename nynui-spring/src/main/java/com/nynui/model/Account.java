package com.nynui.model;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  18:37 2018/8/30
 * @ Modified By :
 */
public class Account implements  java.io.Serializable {

    private int id;

    private String accountName;
    private String user;
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
