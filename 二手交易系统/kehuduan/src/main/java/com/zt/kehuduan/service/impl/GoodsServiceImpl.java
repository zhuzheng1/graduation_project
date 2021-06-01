package com.zt.kehuduan.service.impl;

import com.zt.kehuduan.dao.ConditionDao;
import com.zt.kehuduan.dao.GoodsDao;
import com.zt.kehuduan.dao.UserDao;
import com.zt.kehuduan.domain.Goods;
import com.zt.kehuduan.service.GoodsService;
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

    //首界面数据分页查询
    @Override
    public List<Goods> selectAllGoodsInformation() {
        List<Goods> list = goodsDao.selectAllGoodsInformation();
        return list;
    }

    //goods表中的数据总量
    @Override
    public int selectAllGoodsCount() {
        int count = goodsDao.selectAllGoodsCount();
        return count;
    }

    @Override
    public List<Goods> homePageSelect(String goods_title) {
        List<Goods> list = goodsDao.homePageSelect(goods_title);
        return list;
    }

    @Override
    public List<Goods> homePageScreen(String new_old, String item_status, String origin) {

        String str = "全部";
        if(str.equals(new_old)) {
            new_old = null;
        }
        if(str.equals(item_status)) {
            item_status = null;
        }
        if(str.equals(origin)) {
            origin = null;
        }
        List<Goods> list = conditionDao.homePageScreen(new_old,item_status,origin);

        return list;
    }

    //发布
    @Transactional
    @Override
    public boolean saveGoods(Goods goods, String new_old, String item_status, String origin) {

        boolean flag = false;
        String c_goods_id = null;
        flag = goodsDao.saveGoods(goods);
        if(flag) {
            c_goods_id = goods.getGoods_id();
            flag = conditionDao.saveGoodsCondition(c_goods_id,new_old,item_status,origin);

        }
        return flag;
    }

    @Override
    public List<Goods> lookUsPublish(String user_id) {
        List<Goods> list = goodsDao.lookUsPublish(user_id);
        return list;
    }

    @Override
    public List<Goods> lookUsCollect(String user_id) {
        List<Goods> list = goodsDao.lookUsCollect(user_id);
        return list;
    }

    @Transactional
    @Override
    public boolean deleteGoods(String goods_id) {
        boolean flag = goodsDao.deleteGoods(goods_id);
//        if(flag) {
//            flag = conditionDao.deleteCondition(goods_id);
//        }
        System.out.println(flag+"???????");
        return flag;
    }

    @Override
    public String getImage(String goods_id) {
        String imagePath = goodsDao.getImage(goods_id);
        return imagePath;
    }

    @Override
    public boolean saveGoodsChange(Goods goods, String new_old, String item_status, String origin) {
        boolean flag = goodsDao.saveGoods(goods);
        System.out.println(flag+"11111111111");
        if(flag) {
            flag = conditionDao.updateByGoodsID(goods.getGoods_id(),new_old,item_status,origin);
            System.out.println(flag+"2222222");
        }
        return flag;
    }

    @Override
    public boolean deleteMyCollect(String goods_id, String user_id) {
        boolean flag = userDao.deleteCollect(goods_id,user_id);
        return flag;
    }

    @Override
    public List<Goods> lookUsPublishZero(String user_id) {
        List<Goods> list = goodsDao.lookUsPublishZero(user_id);
        return list;
    }

    @Override
    public boolean deleteCondition(String goods_id) {
        boolean flag = conditionDao.deleteCondition(goods_id);
        return flag;
    }
}
