package com.cx.controller;

import com.cx.domain.*;
import com.cx.service.BookService;
import com.cx.service.BorrowService;
import com.cx.service.ShareService;
import com.cx.service.UserService;
import com.cx.util.DateTimeUtil;
import com.cx.util.MD5Util;
import com.cx.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private ShareService shareService;
    @Autowired
    private BookService bookService;

    @PostMapping("/login")
    public Map<String,Object> login(String username, String password, HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map1 = new LinkedHashMap<>();

        HttpSession session = request.getSession();
        String userID = null;
        String loginPwd = null;

        if(username==null || password==null) {
            map.put("code", 0);
            map.put("msg", "账号密码不能为空");
            return map;
        }

        loginPwd = MD5Util.getMD5(request.getParameter("password"));
        userID = userService.getLoginID(request.getParameter("username"), loginPwd);

        if(userID!=null && !"".equals(userID)) {
            session.setAttribute("username",username);
            session.setAttribute("password", loginPwd);
            map.put("code",200);
            map.put("msg","登录成功");
            map1.put("userID",userID);
            map.put("data",map1);
        }else {
            map.put("code", 0);
            map.put("msg", "登录失败");
        }
        return map;
    }

    @PostMapping("/register")
    public Map<String,Object> register(User user) {

        Map<String, Object> map = new LinkedHashMap<>();
        boolean flag = false;

        String user_id = UUIDUtil.getUUID();

        user.setUser_id(user_id);
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        user.setAuthority(0);

        flag = userService.register(user);
        if(flag) {
            map.put("code",200);
            map.put("msg","注册成功！");
        }else {
            map.put("code",0);
            map.put("msg","注册失败！");
        }
        return map;
    }

    @PostMapping("/change_pwd")
    public Map<String,Object> register(String oldUsername, String oldPWD, String newPWD) {
        Map<String, Object> map = new LinkedHashMap<>();
        boolean flag = false;


        flag = userService.changePWD(oldUsername, MD5Util.getMD5(oldPWD), MD5Util.getMD5(newPWD));
        if(flag) {
            map.put("code",200);
            map.put("msg","修改密码成功！");
        }else {
            map.put("code",0);
            map.put("msg","修改密码失败！");
        }
        return map;
    }

    @GetMapping("/share_borrow")
    public Map<String,Object> shareAndBorrow(String userID) {

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map2 = new LinkedHashMap<>();
        Date time = new Date();

        List<MyBorrow> list1 = borrowService.selectMyBorrow(userID,time);
        List<MyShare> list2 = shareService.selectMyShare(userID,time);
        //时间提醒
        //借书超时未还
        List<MyBorrow> list3 = borrowService.selectBorrowBookTimeOut(time,userID);
        //分享书籍超时未取
        List<MyShare> list4 = shareService.selectShareBookTimeOut(time,userID);

        map2.put("myBorrow",list1);
        map2.put("myShare",list2);
        map2.put("myTimeOutBorrow",list3);
        map2.put("myTimeOutShare",list4);

        map.put("code",200);
        map.put("msg","我的分享书籍和借阅书籍信息");
        map.put("data",map2);

        return map;
    }

    //还书审核
    @PostMapping("return_book")
    public Map<String, Object> returnBook(String borrowID){

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map1 = new LinkedHashMap<>();

        boolean flag = borrowService.changeBorrowStatus(borrowID);
        if(flag) {
            map.put("code",200);
            map.put("msg","还书审核中");
            return map;
        }
        map.put("code",0);
        map.put("msg","还书审核操作失败");
        return map;
    }

    //取书审核
    @PostMapping("get_book")
    public Map<String, Object> getBook(String shareID){
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map2 = new LinkedHashMap<>();

        boolean flag = shareService.changeShareStatus(shareID);
        if(flag) {
            map.put("code",200);
            map.put("msg","取书审核中");
            return map;
        }
        map.put("code",0);
        map.put("msg","取书审核操作失败");
        return map;
    }

    @GetMapping("/able_borrow")
    public Map<String,Object> ableBorrow() {

        Map<String, Object> map = new LinkedHashMap<>();

        List<Book> list = bookService.selectExitBook();

        map.put("code",200);
        map.put("msg","所有在平台待借的书籍");
        map.put("data",list);

        return map;
    }

    //分享功能
    @PostMapping("/share")
    public Map<String,Object> share(Book book, String userID) {

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map1 = new LinkedHashMap<>();
        boolean f1 = false;
        boolean f2 = false;
        String shareID = null;

        book.setBookId(UUIDUtil.getUUID());
        book.setBookStatus("主人处待借");

        if(bookService.selectDistinct(book)) {
            f1 = shareService.shareBook(book);
            if(f1) {
                shareID = UUIDUtil.getUUID();
                f2 = shareService.share(book.getBookId(),userID,shareID);
                if(f2) {
                    map.put("code",200);
                    map.put("msg","正在进行分享操作");
                    map1.put("shareID",shareID);
                    map.put("data",map1);
                    return map;
                }
            }

            map.put("code",0);
            map.put("msg","分享操作失败");
            return map;
        }else {
            map.put("code",0);
            map.put("msg","分享的书籍已经存在");
            return map;
        }
    }

    //借阅功能
    @PostMapping("/borrow")
    public Map<String,Object> borrow(String bookId, String userID) {

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map1 = new LinkedHashMap<>();
        boolean f1 = false;
        boolean f2 = false;
        String borrowID = null;

        f2 = bookService.selectDistinctBorrow(bookId);
        if(f2) {
            Borrow borrow = new Borrow();
            borrowID = UUIDUtil.getUUID();

            borrow.setBorrowId(borrowID);
            borrow.setBookId(bookId);
            borrow.setUserId(userID);
            borrow.setBorrowStartTime(DateTimeUtil.getSysTime());
            borrow.setBorrowStatus(0);

            f1 = borrowService.borrow(borrow);
            if(f1) {
                map.put("code",200);
                map.put("msg","正在进行借阅操作");
                map1.put("borrow",borrowID);
                map.put("data",map1);
                return map;
            }

            map.put("code",0);
            map.put("msg","借阅操作失败");
            return map;
        }else {
            map.put("code",0);
            map.put("msg","借阅的书籍已被借取");
            return map;
        }
    }

    //个人中心
    @GetMapping("/base_information")
    public Map<String,Object> baseInformation(String userID) {

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map1 = new LinkedHashMap<>();

        Map<String,Object> map2 = userService.selectBaseInformation(userID);

        if(map2 != null){
            map.put("code",200);
            map.put("msg","个人中心基本信息展示");
            map1.put("user_information",map2);
            map.put("data",map1);
        }else {
            map.put("code",0);
            map.put("msg","个人信息展示出错");
        }

        return map;
    }

    @GetMapping("/share_borrow_id")
    public Map<String,Object> share_Borrow_ID(String userID) {

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map1 = new LinkedHashMap<>();

        List<BorrowIdVo> list1 = borrowService.selectMyBorrowID(userID);
        List<ShareIdVo> list2 = shareService.selectMyShareID(userID);

        //还书审核信息展示
        List<BorrowIdVo> list3 = borrowService.selectMyBorrowIDTimeOut(userID);
        //取书审核信息展示
        List<ShareIdVo> list4 = shareService.selectMyShareIDTimeOut(userID);

        map1.put("MyBorrowID",list1);
        map1.put("MyShareID",list2);
        map1.put("MyBorrowIDTimeOut",list3);
        map1.put("MyShareIDTimeOut",list4);

        map.put("code",200);
        map.put("msg","个人中心基本信息展示");
        map.put("data",map1);

        return map;
    }

}
