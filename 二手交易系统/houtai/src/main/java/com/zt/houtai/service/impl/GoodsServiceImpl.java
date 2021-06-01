package com.zt.houtai.service.impl;

import com.zt.houtai.dao.ConditionDao;
import com.zt.houtai.dao.GoodsDao;
import com.zt.houtai.dao.UserDao;
import com.zt.houtai.domain.Goods;
import com.zt.houtai.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ConditionDao conditionDao;


}
