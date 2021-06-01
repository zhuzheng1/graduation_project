package com.zt.kehuduan.controller;

import com.zt.kehuduan.dao.ConditionDao;
import com.zt.kehuduan.domain.Goods;
import com.zt.kehuduan.domain.User;
import com.zt.kehuduan.service.GoodsService;
import com.zt.kehuduan.service.UserService;
import com.zt.kehuduan.util.SaveImage;
import com.zt.kehuduan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.image.ImageWatched;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
//    @Autowired
//    private ConditionDao conditionDao;

    //首页
    @GetMapping("/home_page")
    public Map<String,Object> homePage() {
        Map<String,Object> map = new LinkedHashMap<>();

        List<Goods> list = goodsService.selectAllGoodsInformation();
        int count = goodsService.selectAllGoodsCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","返回首页需要展示的商品信息");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","返回首页需要展示的商品信息失败");
        }
        return map;

    }

    //首页搜索功能
    @GetMapping("home_page_select")
    public Map<String,Object> homePageSelect(String goods_title) {
        Map<String,Object> map = new LinkedHashMap<>();

        if(goods_title==null) {
            System.out.println("goods_title:"+goods_title);
            System.exit(0);
        }

        List<Goods> list = goodsService.homePageSelect(goods_title);
        if(list != null) {
            map.put("code",200);
            map.put("msg","首页搜索返回数据");
            map.put("count",list.size());
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","首页搜索返回数据失败");
        }

        return map;
    }

    //首页筛选
    @GetMapping("/home_page_screen")
    public Map<String,Object> homePageScreen(String new_old, String item_status, String origin) {
        Map<String,Object> map = new LinkedHashMap<>();

        System.out.println(new_old+"\n"+item_status+"\n"+origin);

        List<Goods> list = goodsService.homePageScreen(new_old,item_status,origin);
        if(list != null) {
            map.put("code",200);
            map.put("msg","首页筛选返回数据");
            map.put("count",list.size());
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","首页筛选返回数据失败");
        }

        return map;
    }

    //发布
    @PostMapping("/publish")
    public Map<String,Object> publish(HttpServletRequest request, MultipartFile file, Goods goods, String new_old, String item_status, String origin) {
        Map<String,Object> map = new LinkedHashMap<>();
        String goods_id = null;
        String imagePath = null;

        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        System.out.println(request.getRequestURL()+"\n"+request.getRequestURI());
        System.out.println(url.replace(uri,"/"));
        url = url.replace(uri,"/");

        System.out.println(goods+"\n"+new_old+"\n"+item_status+"\n"+origin);

        goods_id = UUIDUtil.getUUID();
        goods.setGoods_id(goods_id);
        goods.setGoods_status(0);
        try {
            imagePath = SaveImage.saveGoodsImage(file,goods_id);
            if(imagePath!=null) {
                goods.setGoods_image("http://localhost:8080/"+imagePath);
            }else {
                System.out.println("iamgePath为空!");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean flag = goodsService.saveGoods(goods,new_old,item_status,origin);
        if(flag) {
            map.put("code",200);
            map.put("msg","发布成功");
        }else {
            map.put("code",0);
            map.put("msg","发布失败");
        }

        return map;
    }

    //添加到我的收藏
    @PostMapping("/add_collect")
    public Map<String,Object> addCollect(String goods_id, String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        System.out.println(goods_id+"\n"+user_id);
        boolean flag = userService.addCollect(goods_id,user_id);
        if(flag) {
            map.put("code",200);
            map.put("msg","添加收藏成功");
        }else {
            map.put("code",0);
            map.put("msg","添加收藏失败或收藏已经存在");
        }

        return map;
    }

    //我的
    @GetMapping("/us")
    public Map<String,Object> us(String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        Map<String,String> map2 = userService.us(user_id);
        String image = userService.getImage(user_id);
        if(map2 != null) {
            map2.put("user_image",image);
            map.put("code",200);
            map.put("msg","个人中心界面");
            map.put("data",map2);
        }else {
            map.put("code",0);
            map.put("msg","个人中心界面信息展示失败");
        }

        return map;
    }

    //我的界面修改头像、QQ、电话
    @Transactional
    @PostMapping("/change_head_portrait")
    public Map<String,Object> changeHeadPortrait(HttpServletRequest request, MultipartFile file, String user_id, String newQQ, String newPhone) throws IOException, InterruptedException {
        Map<String,Object> map = new LinkedHashMap<>();
        System.out.println(user_id+"\n"+newQQ+"\n"+newPhone);

        boolean flag = false;
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        System.out.println(request.getRequestURL()+"\n"+request.getRequestURI());
        System.out.println(url.replace(uri,""));
        if(file!=null) {
            flag = userService.changeHeadPortrait(file,user_id);
            if(flag) {
                flag = userService.changeQQ(newQQ,user_id);
                if(flag) {
                    newPhone = newPhone.replaceAll(" ","");
                    flag = userService.changePhone(newPhone,user_id);
                }
            }
        }else {
            flag = userService.changeQQ(newQQ,user_id);
            if(flag) {
                newPhone = newPhone.replaceAll(" ","");
                flag = userService.changePhone(newPhone,user_id);
            }
        }

        if(flag) {
            map.put("code",200);
            map.put("msg","个人头像修改成功");
        }else {
            map.put("code",0);
            map.put("msg","个人头像修改失败");
        }

        return map;
    }

    //我的界面展示我的发布
    @PostMapping("/look_us_publish")
    public Map<String,Object> lookUsPublish(String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        List<Goods> list = goodsService.lookUsPublish(user_id);
        if(list != null) {
            map.put("code",200);
            map.put("msg","展示我的发布");
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","展示我的发布失败");
        }
        return map;
    }

    //编辑我的发布
    @PostMapping("/change_publish")
    public Map<String,Object> changePublish(MultipartFile file, Goods goods, String new_old, String item_status, String origin) throws InterruptedException {
        Map<String,Object> map = new LinkedHashMap<>();
        String imagePath = null;

        System.out.println("修改我的发布："+goods+"\n"+new_old+"\n"+item_status+"\n"+origin);

        if(file != null) {
            imagePath = goodsService.getImage(goods.getGoods_id());

            try {
                imagePath = imagePath.replaceAll("http://localhost:8080/","/");
                boolean flag = SaveImage.deleteGoodsImage(imagePath);
                if(flag) {
                    imagePath = SaveImage.saveGoodsImage(file,goods.getGoods_id());
                }
                if(imagePath!=null) {
                    Thread.sleep(5000);
                    imagePath = "http://localhost:8080/" + imagePath;
                    goods.setGoods_image(imagePath);
                }else {
                    System.out.println("iamgePath为空!");
                    System.exit(0);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(imagePath == null) {
            goods.setGoods_image(goodsService.getImage(goods.getGoods_id()));
        }

        goods.setGoods_phone(goods.getGoods_phone().replaceAll(" ",""));

        boolean flag1 = false;
        boolean flag2 = goodsService.deleteGoods(goods.getGoods_id());
        System.out.println(flag2+"<><><><>");
        if(flag2) {
            flag1 = goodsService.saveGoodsChange(goods,new_old,item_status,origin);
            System.out.println(flag1+"{{{{{{{{{{{{{");
        }
        if(flag1) {
            Thread.sleep(1000);
            map.put("code",200);
            map.put("msg","编辑我的发布成功");
        }else {
            map.put("code",0);
            map.put("msg","编辑我的发布失败");
        }

        return map;
    }

    //删除我的发布
    @Transactional
    @DeleteMapping("/delete_publish")
    public Map<String,Object> deletePublish(String goods_id, String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        boolean flag = false;

        String image = goodsService.getImage(goods_id);
        image =image.replaceAll("http://localhost:8080/","/");
        if(SaveImage.deleteGoodsImage(image)) {
            flag = goodsService.deleteGoods(goods_id);
            if(flag) {
                flag = goodsService.deleteCondition(goods_id);
                if(flag) {
                    flag = userService.deleteCollect(goods_id,user_id);
                }
            }
        }

        if(flag) {
            map.put("code",200);
            map.put("msg","删除我的发布");
        }else {
            map.put("code",0);
            map.put("msg","删除我的发布失败");
        }

        return map;
    }

    //展示我的发布审核
    @GetMapping("look_us_publish_0")
    public Map<String,Object> lookUsPublishZero(String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        List<Goods> list = goodsService.lookUsPublishZero(user_id);
        if(list != null) {
            map.put("code",200);
            map.put("msg","展示我的发布审核");
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","展示我的发布审核失败");
        }
        return map;
    }

    //删除我的发布审核
    @DeleteMapping("/delete_publish_0")
    public Map<String,Object> deletePublishZero(String goods_id) {
        Map<String,Object> map = new LinkedHashMap<>();
        System.out.println(goods_id);
        boolean flag = false;

        String image = goodsService.getImage(goods_id);
        System.out.println(image);
        image =image.replaceAll("http://localhost:8080/","/");
        if(SaveImage.deleteGoodsImage(image)) {
            flag = goodsService.deleteGoods(goods_id);
        }

        if(flag) {
            map.put("code",200);
            map.put("msg","删除我的发布审核");
        }else {
            map.put("code",0);
            map.put("msg","删除我的发布审核失败");
        }

        return map;
    }

    //我的界面展示我的收藏
    @GetMapping("/look_us_collect")
    public Map<String,Object> lookUsCollect(String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        List<Goods> list = goodsService.lookUsCollect(user_id);
        if(list != null) {
            map.put("code",200);
            map.put("msg","展示我的收藏");
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","展示我的收藏失败");
        }
        return map;
    }

    //取消我的收藏
    @DeleteMapping("/delete_my_collect")
    public Map<String,Object> deleteMyCollect(String goods_id, String user_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        boolean flag = goodsService.deleteMyCollect(goods_id,user_id);
        if(flag) {
            map.put("code",200);
            map.put("msg","取消我的收藏");
        }else {
            map.put("code",0);
            map.put("msg","取消我的收藏");
        }
        return map;
    }
}
