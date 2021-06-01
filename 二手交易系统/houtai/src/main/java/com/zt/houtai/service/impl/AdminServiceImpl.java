package com.zt.houtai.service.impl;

import com.zt.houtai.dao.AdminDao;
import com.zt.houtai.dao.ConditionDao;
import com.zt.houtai.dao.GoodsDao;
import com.zt.houtai.dao.UserDao;
import com.zt.houtai.domain.Goods;
import com.zt.houtai.domain.User;
import com.zt.houtai.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ConditionDao conditionDao;

    //登录验证
    @Override
    public String login(String admin_name, String md5) {
        String admin_id = adminDao.login(admin_name,md5);
        return admin_id;
    }

    @Override
    public List<User> accountment(Integer limit, Integer page) {

        List<User> list = userDao.selectAllUserInformation(limit,page);
        return list;
    }

    @Override
    public int selectAllGoodsCount() {

        int count = userDao.selectUserCount();
        return count;
    }

    @Override
    public List<Goods> adminPublishZero(Integer page, Integer limit) {
        List<Goods> list = adminDao.adminPublishZero(page,limit);
        return list;
    }

    @Override
    public List<Goods> sendInformation(Integer page, Integer limit) {
        List<Goods> list = adminDao.sendInformation(page,limit);
        return list;
    }

    @Override
    public boolean publishPass(String goods_id) {
        boolean flag = adminDao.publishPass(goods_id);
        return flag;
    }

    @Transactional
    @Override
    public boolean publishNoPass(String goods_id) {
        boolean flag = adminDao.publishNoPass(goods_id);
        if(flag) {
            flag = conditionDao.deleteByGoodsID(goods_id);
        }
        return flag;
    }

    @Override
    public List<User> selectAccountManagement(String user_name) {
        List<User> list = adminDao.selectAccountManagement(user_name);
        return list;
    }

    @Override
    public List<Goods> adminPublishOne(String goods_title) {
        List<Goods> list = adminDao.adminPublishOne(goods_title);
        return list;
    }

    @Override
    public int selectAllGoodsPublishCount() {
        int count = goodsDao.selectAllGoodsPublishCount();
        return count;
    }

    @Override
    public int selectAllGoodsOneCount() {
        int count = goodsDao.selectAllGoodsOneCount();
        return count;
    }

    @Override
    public List<Goods> sendInformationSelect(String goods_title) {
        List<Goods> list = adminDao.sendInformationSelect(goods_title);
        return list;
    }
}
