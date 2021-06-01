package com.zt.kehuduan.service;

import com.zt.kehuduan.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectAllGoodsInformation();

    int selectAllGoodsCount();

    List<Goods> homePageSelect(String goods_title);

    List<Goods> homePageScreen(String new_old, String item_status, String origin);

    boolean saveGoods(Goods goods, String new_old, String item_status, String origin);

    List<Goods> lookUsPublish(String user_id);

    List<Goods> lookUsCollect(String user_id);

    boolean deleteGoods(String goods_id);

    String getImage(String goods_id);

    boolean saveGoodsChange(Goods goods, String new_old, String item_status, String origin);

    boolean deleteMyCollect(String goods_id, String user_id);

    List<Goods> lookUsPublishZero(String user_id);

    boolean deleteCondition(String goods_id);
}
