package com.cx.dao;

import com.cx.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    String selectByNameAndPWD(String username, String password);

    boolean register(User user);

    boolean changePWD(String oldUsername, String oldPWD, String newPWD);

    Map<String, Object> selectBaseInformation(String userID);
}