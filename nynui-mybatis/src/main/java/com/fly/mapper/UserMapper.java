package com.fly.mapper;

import java.util.List;

import com.fly.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    
    User selectUser(Integer id);
}