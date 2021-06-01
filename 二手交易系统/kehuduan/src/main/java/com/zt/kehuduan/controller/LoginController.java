package com.zt.kehuduan.controller;

import com.zt.kehuduan.domain.User;
import com.zt.kehuduan.service.UserService;
import com.zt.kehuduan.util.MD5Util;
import com.zt.kehuduan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/login_screen")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(String user_name, String user_password, HttpSession session) {
        Map<String, Object> map = new LinkedHashMap<>();

        //存储Session
        if(user_name!=null && (!"".equals(user_name)) && user_password!=null && !("".equals(user_password))) {
            session.setAttribute("user_name",user_name);
            session.setAttribute("password",user_password);
        }

        //开始进行登录验证
        String user_id = userService.login(user_name,MD5Util.getMD5(user_password));
        if(user_id!=null && !"".equals(user_id)) {
            map.put("code",200);
            map.put("msg","登录成功");
            map.put("data",user_id);
        }else {
            map.put("code",0);
            map.put("msg","登录失败");
        }

        return map;
    }

    //注册
    @PostMapping("/register")
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new LinkedHashMap<>();
        String user_id = null;
        //System.out.println(user.getUser_phone()+"?????????");
        if(user!=null) {
            user_id = UUIDUtil.getUUID();
            user.setUser_id(user_id);
            user.setUser_password(MD5Util.getMD5(user.getUser_password()));
            user.setUser_image("http://localhost:8080/static/default/default.jpg");
        }
        //开始进行注册验证
        boolean flag = userService.register(user);
        if(flag) {
            map.put("code",200);
            map.put("msg","注册成功");
        }else {
            map.put("code",0);
            map.put("msg","注册失败");
        }

        return map;
    }
}
