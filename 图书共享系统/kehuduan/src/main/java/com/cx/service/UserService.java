package com.cx.service;

import com.cx.domain.User;

import java.util.Map;

public interface UserService {
    String getLoginID(String username, String password);

    boolean login(String username, String password);

    boolean register(User user);

    boolean changePWD(String oldUsername, String oldPWD, String newPWD);

    Map<String, Object> selectBaseInformation(String userID);
}
