package com.zt.kehuduan.dao;

import com.zt.kehuduan.domain.Goods;

import java.util.List;

public interface ConditionDao {
    List<Goods> homePageScreen(String new_old, String item_status, String origin);

    boolean saveGoodsCondition(String goods_id, String new_old, String item_status, String origin);

    boolean updateByGoodsID(String goods_id, String new_old, String item_status, String origin);

    boolean deleteCondition(String goods_id);
}
