package com.zt.kehuduan.dao;

import com.zt.kehuduan.domain.User;

import java.util.Map;

public interface UserDao {
    String login(String user_name, String password);

    boolean register(User user);

    Map<String, String> selectMyInformation(String user_id);

    String getUserImage(String user_id);

    boolean updateUserImage(String user_image, String user_id);

    boolean changeQQ(String newQQ, String user_id);

    boolean changePhone(String newPhone, String user_id);

    boolean addCollect(String goods_id, String user_id);

    String selectCollet(String goods_id, String user_id);

    boolean deleteCollect(String goods_id, String user_id);

    boolean deleteCollectByGoodsID(String goods_id);
}
