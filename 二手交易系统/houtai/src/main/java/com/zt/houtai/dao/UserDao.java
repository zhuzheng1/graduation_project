package com.zt.houtai.dao;

import com.zt.houtai.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int selectUserCount();

    List<User> selectAllUserInformation(Integer limit, Integer page);
}
