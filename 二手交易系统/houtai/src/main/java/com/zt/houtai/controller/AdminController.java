package com.zt.houtai.controller;

import com.zt.houtai.domain.Goods;
import com.zt.houtai.domain.User;
import com.zt.houtai.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //账号管理
    @GetMapping("/account_management")
    public Map<String, Object> accountment(Integer limit, Integer page) {
        Map<String,Object> map = new LinkedHashMap<>();

        if(limit==null || page==null) {
            System.out.println("limit:"+limit);
            System.out.println("page:"+page);
            System.exit(0);
        }

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<User> list = adminService.accountment(limit,page);
        int count = adminService.selectAllGoodsCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","账号管理");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","账号管理信息查询失败");
        }

        return map;
    }

    //用户账号管理搜索功能
    @GetMapping("/select_account_management")
    public Map<String,Object> selectAccountManagement(String user_name) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<User> list = adminService.selectAccountManagement(user_name);
        if(list != null) {
            map.put("code",200);
            map.put("msg","用户账号管理搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "用户账号管理搜索失败");
        }
        return map;
    }

    //发布审核
    @GetMapping("admin_publish_0")
    public Map<String, Object> adminPublishZero(Integer page, Integer limit) {
        Map<String,Object> map = new LinkedHashMap<>();

        if(limit==null || page==null) {
            System.out.println("limit:"+limit);
            System.out.println("page:"+page);
            System.exit(0);
        }

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<Goods> list = adminService.adminPublishZero(page,limit);
        int count = adminService.selectAllGoodsPublishCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","发布审核");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","发布审核信息展示失败");
        }
        return map;
    }

    //发布审核搜索功能
    @GetMapping("/admin_publish_1")
    public Map<String,Object> adminPublishOne(String goods_title) {
        Map<String, Object> map = new LinkedHashMap<>();

        System.out.println(goods_title+"?????");
        List<Goods> list = adminService.adminPublishOne(goods_title);
        if(list != null) {
            map.put("code",200);
            map.put("msg","发布审核搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "发布审核搜索失败");
        }
        return map;
    }

    //审核通过
    @PostMapping("publish_pass")
    public Map<String, Object> publishPass(String goods_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        boolean flag = adminService.publishPass(goods_id);
        if(flag) {
            map.put("code",200);
            map.put("msg","审核通过");
        }else {
            map.put("code",0);
            map.put("msg","审核失败");
        }
        return map;
    }

    //审核不通过
    @PostMapping("publish_no_pass")
    public Map<String, Object> publishNoPass(String goods_id) {
        Map<String,Object> map = new LinkedHashMap<>();

        boolean flag = adminService.publishNoPass(goods_id);
        if(flag) {
            map.put("code",200);
            map.put("msg","审核不通过");
        }else {
            map.put("code",0);
            map.put("msg","审核失败");
        }
        return map;
    }

    //二手手机出售信息
    @GetMapping("send_information")
    public Map<String, Object> sendInformation(Integer page, Integer limit) {
        Map<String,Object> map = new LinkedHashMap<>();

        if(limit==null || page==null) {
            System.out.println("limit:"+limit);
            System.out.println("page:"+page);
            System.exit(0);
        }

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<Goods> list = adminService.sendInformation(page, limit);
        int count = adminService.selectAllGoodsOneCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","二手手机出售信息");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code",0);
            map.put("msg","二手手机出售信息展示失败");
        }
        return map;
    }

    //二手手机出售信息搜索功能
    @GetMapping("/send_information_select")
    public Map<String,Object> sendInformationSelect(String goods_title) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<Goods> list = adminService.sendInformationSelect(goods_title);
        if(list != null) {
            map.put("code",200);
            map.put("msg","二手手机出售信息搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "二手手机出售信息搜索失败");
        }
        return map;
    }
}
