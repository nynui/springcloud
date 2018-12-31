package com.nynui.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserSerivce {
    public void createUser(String name);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void addAccount(String name, int initMoney);
}