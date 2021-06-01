package com.cx.controller;

import com.cx.domain.*;
import com.cx.service.AdminService;
import com.cx.service.BookService;
import com.cx.service.BorrowService;
import com.cx.service.ShareService;
import com.cx.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
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
        String adminID = null;
        String loginPwd = null;

        loginPwd = MD5Util.getMD5(password);
        adminID = adminService.login(username, loginPwd);

        if(adminID!=null && !"".equals(adminID)) {
            session.setAttribute("username",username);
            session.setAttribute("password", loginPwd);
            map.put("code",200);
            map.put("msg","登录成功");
            map1.put("adminID",adminID);
            map.put("data",map1);
        }else {
            map.put("code", 0);
            map.put("msg", "登录失败");
        }
        return map;
    }

//    @PostMapping("/register")
//    public Map<String,Object> register(Admin admin) {
//
//        Map<String, Object> map = new LinkedHashMap<>();
//        boolean flag = false;
//
//        String admin_id = UUIDUtil.getUUID();
//        System.out.println(MD5Util.getMD5(admin.getPassword()));
//        admin.setAdminId(admin_id);
//        admin.setPassword(MD5Util.getMD5(admin.getPassword()));
//        admin.setAuthority(1);
//
//        flag = adminService.register(admin);
//        if(flag) {
//            map.put("code",200);
//            map.put("msg","注册成功！");
//        }else {
//            map.put("code",0);
//            map.put("msg","注册失败！");
//        }
//        return map;
//    }

    //用户账号管理
    @GetMapping("/account_management")
    public Map<String,Object> accountManagement(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }
        List<User> list = adminService.selectAllUser(limit,page);
        int count = adminService.selectUserCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","账户管理");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "账户管理查询失败");
        }
        return map;
    }

    //用户账号管理搜索功能
    @GetMapping("/select_account_management")
    public Map<String,Object> selectAccountManagement(String userID) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<User> list = adminService.selectAccountManagement(userID);
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

    //分享审核中
    @GetMapping("/share_under_review")
    public Map<String,Object> shareUnderReview(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<ShareUnderReview> list = adminService.selectAllShareUnderReview(limit,page);
        int count = adminService.selectShareUnderReviewCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","分享审核");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "分享审核中信息查询失败");
        }
        return map;
    }

    @GetMapping("/select_user_share")
    public Map<String,Object> selectUserShare(String shareID) {
        Map<String, Object> map = new LinkedHashMap<>();
//        Map<String, Object> map1 = new LinkedHashMap<>();

        List<ShareUnderReview> list = adminService.selectUserShareByShareID(shareID);
        if(list != null) {
            map.put("code",200);
            map.put("msg","分享用户审核信息查询");
//            map1.put("share_user_list",list);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "分享用户信息查询失败");
        }
        return map;
    }

    @PostMapping("/share_complete")
    public Map<String,Object> shareComplete(String shareID, String backTime) throws ParseException {
        Map<String, Object> map = new LinkedHashMap<>();

        boolean flag = adminService.shareComplete(shareID,backTime);
        if(flag) {
            map.put("code",200);
            map.put("msg","分享完成");
        }else {
            map.put("code", 0);
            map.put("msg", "信息输入有误，分享失败");
        }
        return map;
    }

    //借阅审核中
    @GetMapping("/borrow_under_review")
    public Map<String,Object> borrowUnderReview(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<BorrowUnderReview> list = adminService.selectAllBorrowUnderReview(limit,page);
        int count = adminService.selectBorrowUnderReviewCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","借阅审核");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "借阅审核中信息查询失败");
        }
        return map;
    }

    @GetMapping("/select_user_borrow")
    public Map<String,Object> selectUserBorrow(String borrowID) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<BorrowUnderReview> list = adminService.selectUserBorrowByBorrowID(borrowID);
        if(list != null) {
            map.put("code",200);
            map.put("msg","借阅用户审核信息查询");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "借阅用户信息查询失败");
        }
        return map;
    }

    @PostMapping("/borrow_complete")
    public Map<String,Object> borrowComplete(String borrowID, String borrow_end_time) throws ParseException {
        Map<String, Object> map = new LinkedHashMap<>();

        String time = adminService.selectShareEndTime(borrowID,borrow_end_time);
        if(time != null) {
            map.put("code",1);
            map.put("msg","借阅结束时间超过分享结束时间，借阅失败");
            map.put("data",time);
            return map;
        }

        boolean flag = adminService.borrowComplete(borrowID,borrow_end_time);
        if(flag) {
            map.put("code",200);
            map.put("msg","借阅完成");
        }else {
            map.put("code", 0);
            map.put("msg", "借阅失败");
        }
        return map;
    }

    //在库
    @GetMapping("/in_the_library")
    public Map<String,Object> inTheLibrary(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<Book> list = adminService.inTheLibrary(limit,page);
        int count = adminService.selectInTheLibraryCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","在库书籍信息");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "在库书籍信息展示失败");
        }
        return map;
    }

    //在库搜索功能
    @GetMapping("/select_in_the_library")
    public Map<String,Object> selectInTheLibrary(String bookName) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<Book> list = adminService.selectInTheLibrary(bookName);
        if(list != null) {
            map.put("code",200);
            map.put("msg","在库搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "在库搜索失败");
        }
        return map;
    }

    //借出
    @GetMapping("/lend")
    public Map<String,Object> lend(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<Book> list = adminService.lend(limit,page);
        int count = adminService.selectLendCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","借出书籍信息");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "借出书籍信息展示失败");
        }
        return map;
    }

    //借出搜索功能
    @GetMapping("/select_lend")
    public Map<String,Object> selectLend(String bookName) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<Book> list = adminService.selectLend(bookName);
        if(list != null) {
            map.put("code",200);
            map.put("msg","借出搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "借出搜索失败");
        }
        return map;
    }

    //还书界面
    @GetMapping("/back_book")
    public Map<String, Object> backBook(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<BackBook> list = adminService.selectBackBook(limit,page);
        int count = adminService.selectBackBookCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","还书审核");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "还书审核中信息查询失败");
        }
        return map;
    }

    //还书搜索功能
    @GetMapping("/back_book_select")
    public Map<String,Object> backBookSelect(String borrowID) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<BackBook> list = adminService.backBookSelect(borrowID);
        if(list != null) {
            map.put("code",200);
            map.put("msg","还书搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "还书搜索失败");
        }
        return map;
    }

    //还书完成
    @PostMapping("/back_book_complete")
    public Map<String,Object> backBookComplete(String borrowID) {
        Map<String, Object> map = new LinkedHashMap<>();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean flag = adminService.backBookComplete(borrowID,sdf.format(nowTime),nowTime);
        if(flag) {
            map.put("code",200);
            map.put("msg","还书完成");
        }else {
            map.put("code", 0);
            map.put("msg", "还书失败");
        }
        return map;
    }

    //取书界面
    @GetMapping("/get_book")
    public Map<String, Object> getBook(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        List<GetBook> list = adminService.selectGetBook(limit,page);
        int count = adminService.selectGetBookCount();
        if(list != null) {
            map.put("code",200);
            map.put("msg","取书审核");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "取书审核中信息查询失败");
        }
        return map;
    }

    //取书搜索功能
    @GetMapping("/get_book_select")
    public Map<String,Object> getBookSelect(String shareID) {
        Map<String, Object> map = new LinkedHashMap<>();

        List<GetBook> list = adminService.getBookSelect(shareID);
        if(list != null) {
            map.put("code",200);
            map.put("msg","取书搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "取书搜索失败");
        }
        return map;
    }

    //取书完成
    @PostMapping("/get_book_complete")
    public Map<String,Object> getBookComplete(String shareID) {
        Map<String, Object> map = new LinkedHashMap<>();

        Date nowTime = new Date();
        boolean flag = adminService.getBookComplete(shareID,nowTime);
        if(flag) {
            map.put("code",200);
            map.put("msg","取书完成");
        }else {
            map.put("code", 0);
            map.put("msg", "取书失败");
        }
        return map;
    }

    //超时未还
    @GetMapping("back_book_timeout")
    public Map<String,Object> backBookTimeOut(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        Date nowTime = new Date();
        List<BackBook> list = adminService.selectBackBookTimeOut(limit,page,nowTime);
        int count = adminService.selectBackBookTimeOutCount(nowTime);
        if(list != null) {
            map.put("code",200);
            map.put("msg","超时未还");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "超时未还信息查询失败");
        }
        return map;
    }

    //超时未还搜索功能
    @GetMapping("/back_book_timeout_select")
    public Map<String,Object> backBookTimeOutSelect(String borrowID){
        Map<String, Object> map = new LinkedHashMap<>();

        Date nowTime = new Date();

        List<BackBook> list = adminService.backBookTimeOutSelect(borrowID,nowTime);
        if(list != null) {
            map.put("code",200);
            map.put("msg","超时未还");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "超时未还搜索失败");
        }
        return map;
    }

    //超时未取
    @GetMapping("get_book_timeout")
    public Map<String,Object> getBookTimeOut(Integer limit, Integer page) {
        Map<String, Object> map = new LinkedHashMap<>();

        //数据库从哪一条开始查询
        page=(page-1)*limit;
        if(page>0) {
            page=page-1;
        }

        Date nowTime = new Date();
        List<GetBook> list = adminService.selectGetBookTimeOut(limit,page,nowTime);
        int count = adminService.selectGetBookTimeOutCount(nowTime);
        if(list != null) {
            map.put("code",200);
            map.put("msg","超时未取");
            map.put("count",count);
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "超时未取信息查询失败");
        }
        return map;
    }

    //超时未取搜索功能
    @GetMapping("/get_book_timeout_select")
    public Map<String,Object> getBookTimeOutSelect(String shareID) {
        Map<String, Object> map = new LinkedHashMap<>();

        Date nowTime = new Date();

        List<GetBook> list = adminService.getBookTimeOutSelect(shareID,nowTime);
        if(list != null) {
            map.put("code",200);
            map.put("msg","超时未取搜索");
            map.put("data",list);
        }else {
            map.put("code", 0);
            map.put("msg", "超时未取搜索失败");
        }
        return map;
    }


}


