package com.zt.houtai.controller;

import com.zt.houtai.domain.User;
import com.zt.houtai.service.AdminService;
import com.zt.houtai.service.UserService;
import com.zt.houtai.util.MD5Util;
import com.zt.houtai.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin_login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    //后台管理员登录
    @PostMapping("/login")
    public Map<String, Object> login(String admin_name, String admin_password, HttpSession session) {
        Map<String, Object> map = new LinkedHashMap<>();

        //存储Session
        if(admin_name!=null && (!"".equals(admin_name)) && admin_password!=null && !("".equals(admin_password))) {
            session.setAttribute("admin_name",admin_name);
            session.setAttribute("password",admin_password);
        }

        //开始进行登录验证
        String admin_id = adminService.login(admin_name,MD5Util.getMD5(admin_password));
        if(admin_id!=null && !"".equals(admin_id)) {
            map.put("code",200);
            map.put("msg","登录成功");
            map.put("data",admin_id);
        }else {
            map.put("code",0);
            map.put("msg","登录失败");
        }

        return map;
    }

//    //注册
//    @PostMapping("/register")
//    public Map<String, Object> register(User user) {
//        Map<String, Object> map = new LinkedHashMap<>();
//        String user_id = null;
//
//        if(user!=null) {
//            user_id = UUIDUtil.getUUID();
//            user.setUser_id(user_id);
//            user.setUser_password(MD5Util.getMD5(user.getUser_password()));
//        }
//        //开始进行注册验证
//        boolean flag = userService.register(user);
//        if(flag) {
//            map.put("code",200);
//            map.put("msg","注册成功");
//        }else {
//            map.put("code",0);
//            map.put("msg","注册失败");
//        }
//
//        return map;
//    }
}
