package com.zt.kehuduan.dao;

import com.zt.kehuduan.domain.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectAllGoodsInformation();

    int selectAllGoodsCount();

    List<Goods> homePageSelect(String goods_title);

    boolean saveGoods(Goods goods);

    List<Goods> lookUsPublish(String user_id);

    boolean changeQQ(String newQQ, String user_id);

    boolean changePhone(String newPhone, String user_id);

    List<Goods> lookUsCollect(String user_id);

    boolean deleteGoods(String goods_id);

    String getImage(String goods_id);

    List<Goods> lookUsPublishZero(String user_id);
}
