package com.zt.houtai.service;

import com.zt.houtai.domain.Goods;
import com.zt.houtai.domain.User;

import java.util.List;

public interface AdminService {
    String login(String admin_name, String md5);

    List<User> accountment(Integer limit, Integer page);

    int selectAllGoodsCount();

    List<Goods> adminPublishZero(Integer page, Integer limit);

    List<Goods> sendInformation(Integer page, Integer limit);

    boolean publishPass(String goods_id);

    boolean publishNoPass(String goods_id);

    List<User> selectAccountManagement(String user_name);

    List<Goods> adminPublishOne(String goods_title);

    int selectAllGoodsPublishCount();

    int selectAllGoodsOneCount();

    List<Goods> sendInformationSelect(String goods_title);
}
