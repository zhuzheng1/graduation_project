package com.zt.kehuduan.service.impl;

import com.zt.kehuduan.dao.GoodsDao;
import com.zt.kehuduan.dao.UserDao;
import com.zt.kehuduan.domain.Goods;
import com.zt.kehuduan.domain.User;
import com.zt.kehuduan.service.UserService;
import com.zt.kehuduan.util.SaveImage;
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

    //登录
    @Override
    public String login(String user_name, String password) {

        String user_id = userDao.login(user_name,password);
        return user_id;
    }

    @Override
    public boolean register(User user) {

        boolean flag = userDao.register(user);
        return flag;
    }

    @Override
    public Map<String, String> us(String user_id) {
        Map<String,String> map = userDao.selectMyInformation(user_id);
        return map;
    }

    //修改头像
    @Override
    public boolean changeHeadPortrait(MultipartFile file, String user_id) throws IOException, InterruptedException {

        String user_image = null;
        boolean flag = false;

        user_image = userDao.getUserImage(user_id);

        if("http://localhost:8080/static/default/default.jpg".equals(user_image)) {
            user_image =  SaveImage.saveUserImage(file,user_id);
            user_image = "http://localhost:8080" + user_image;
            Thread.sleep(5000);
            if(user_image != null) {
               flag = userDao.updateUserImage(user_image,user_id);
            }
        }else {
            user_image = user_image.replaceAll("http://localhost:8080/","/");
            System.out.println(user_image+">>>>>>>>");
            if(SaveImage.deleteUserImage(user_image)) {
                System.out.println("??????");
                try {
                    user_image = SaveImage.saveUserImage(file,user_id);
                    user_image = "http://localhost:8080" + user_image;
                    Thread.sleep(5000);
                    if(user_image != null) {
                        flag = userDao.updateUserImage(user_image,user_id);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean changeQQ(String newQQ, String user_id) {

        boolean flag = userDao.changeQQ(newQQ,user_id);
        System.out.println(flag+">>>>>>>>>");
//        if(flag) {
//            flag = goodsDao.changeQQ(newQQ,user_id);
//        }
        return flag;
    }

    @Override
    public boolean changePhone(String newPhone, String user_id) {
        boolean flag = userDao.changePhone(newPhone, user_id);
        System.out.println(flag+"????????");
//        if(flag) {
//            Goods str = goodsDao
//            flag = goodsDao.changePhone(newPhone, user_id);
//        }
        return flag;
    }

    @Override
    public boolean addCollect(String goods_id, String user_id) {

        boolean flag = false;
        String collect = null;

            collect = userDao.selectCollet(goods_id, user_id);
            if(collect == null) {
                flag = userDao.addCollect(goods_id, user_id);
            }

        return flag;
    }

    @Override
    public boolean deleteCollect(String goods_id, String user_id) {
        boolean flag = userDao.deleteCollect(goods_id,user_id);
        return flag;
    }

    @Override
    public boolean deleteCollect(String goods_id) {
        boolean flag = userDao.deleteCollectByGoodsID(goods_id);
        return flag;
    }

    @Override
    public String getImage(String user_id) {
        String image = userDao.getUserImage(user_id);
        return image;
    }
}
