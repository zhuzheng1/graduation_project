package com.zt.houtai.service.impl;

import com.zt.houtai.dao.GoodsDao;
import com.zt.houtai.dao.UserDao;
import com.zt.houtai.domain.User;
import com.zt.houtai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;


}
