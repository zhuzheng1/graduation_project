package com.cx.service.impl;

import com.cx.dao.UserMapper;
import com.cx.domain.User;
import com.cx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String getLoginID(String username, String password) {
        String userId = userMapper.selectByNameAndPWD(username, password);
        return userId;
    }

    @Override
    public boolean login(String username, String password) {

        String userId = userMapper.selectByNameAndPWD(username, password);
        if(userId!=null && !"".equals(userId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {

        boolean flag = false;
        if(!login(user.getUsername(), user.getPassword())) {
            flag = userMapper.register(user);
        }
        return flag;
    }

    @Override
    public boolean changePWD(String oldUsername, String oldPWD, String newPWD) {
        boolean flag = userMapper.changePWD(oldUsername, oldPWD, newPWD);
        return flag;
    }

    @Override
    public Map<String, Object> selectBaseInformation(String userID) {

        Map<String, Object> map = userMapper.selectBaseInformation(userID);
        return map;
    }
}
