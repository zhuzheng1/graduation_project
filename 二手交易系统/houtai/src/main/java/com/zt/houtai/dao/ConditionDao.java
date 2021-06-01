package com.zt.houtai.dao;

import com.zt.houtai.domain.Goods;

import java.util.List;

public interface ConditionDao {
    List<Goods> homePageScreen(String new_old, String item_status, String origin);

    boolean saveGoodsCondition(String goods_id, String new_old, String item_status, String origin);

    boolean updateByGoodsID(String new_old, String item_status, String origin);

    boolean deleteByGoodsID(String goods_id);
}
