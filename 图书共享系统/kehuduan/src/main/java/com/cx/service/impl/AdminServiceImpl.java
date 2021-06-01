package com.cx.service.impl;

import com.cx.dao.AdminMapper;
import com.cx.domain.*;
import com.cx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired//(required=true)
            AdminMapper adminMapper;

    @Override
    public String login(String username, String password) {
        return adminMapper.selectByNameAndPWD(username, password);
    }

//    @Override
//    public boolean register(Admin admin) {
//        boolean flag = false;
//        if((login(admin.getUsername(), admin.getPassword()) == null)) {
//            flag = adminMapper.register(admin);
//        }
//        return flag;
//    }

    @Override
    public List<User> selectAllUser(Integer limit, Integer page) {

        List<User> list = adminMapper.selectAllUser(limit,page);
        return list;
    }

    @Override
    public List<ShareUnderReview> selectAllShareUnderReview(Integer limit, Integer page) {
        List<ShareUnderReview> list = adminMapper.selectAllShareUnderReview(limit,page);
        return list;
    }

    @Override
    public ShareUnderReview selectUserShareByShareID(String shareID) {
        ShareUnderReview shareUnderReview = adminMapper.selectUserShareByShareID(shareID);
        return shareUnderReview;
    }

    @Transactional
    @Override
    public boolean shareComplete(String shareID, String backTime) {

        boolean flag = adminMapper.updateShareStatus(shareID,backTime);
        if(flag) {
            String bookID = adminMapper.selectShareBookID(shareID);
            flag = adminMapper.updateBookStatus(bookID);
        }
        return flag;
    }

    @Override
    public List<BorrowUnderReview> selectAllBorrowUnderReview(Integer limit, Integer page) {
        List<BorrowUnderReview> list = adminMapper.selectAllBorrowUnderReview(limit,page);
        return list;
    }

    @Override
    public BorrowUnderReview selectUserBorrowByBorrowID(String borrowID) {
        BorrowUnderReview borrowUnderReview = adminMapper.selectUserBorrowByBorrowID(borrowID);
        return borrowUnderReview;
    }

    @Override
    public boolean borrowComplete(String borrowID, String borrow_end_time) {
        boolean flag = adminMapper.updateBorrowStatus(borrowID,borrow_end_time);
        if(flag) {
            String bookID = adminMapper.selectBorrowBookID(borrowID);
            flag = adminMapper.updateBorrowBookStatus(bookID);
        }
        return flag;
    }

    @Override
    public List<Book> inTheLibrary(Integer limit, Integer page) {
        List<Book> list = adminMapper.inTheLibrary(limit,page);
        return list;
    }

    @Override
    public List<Book> lend(Integer limit, Integer page) {
        List<Book> list = adminMapper.lend(limit,page);
        return list;
    }

    @Override
    public int selectUserCount() {
        int count = adminMapper.selectUserCount();
        return count;
    }

    @Override
    public int selectShareUnderReviewCount() {
        int count = adminMapper.selectShareUnderReviewCount();
        return count;
    }

    @Override
    public int selectBorrowUnderReviewCount() {
        int count = adminMapper.selectBorrowUnderReviewCount();
        return count;
    }

    @Override
    public int selectInTheLibraryCount() {
        int count = adminMapper.selectInTheLibraryCount();
        return count;
    }

    @Override
    public int selectLendCount() {
        int count = adminMapper.selectLendCount();
        return count;
    }

    //还书审核中
    @Override
    public List<BackBook> selectBackBook(Integer limit, Integer page) {
        List<BackBook> list = adminMapper.selectBackBook(limit,page);
        return list;
    }

    @Override
    public int selectBackBookCount() {
        int count = adminMapper.selectBackBookCount();
        return count;
    }

    @Override
    public List<GetBook> selectGetBook(Integer limit, Integer page) {
        List<GetBook> list = adminMapper.selectGetBook(limit,page);
        return list;
    }

    @Override
    public int selectGetBookCount() {
        int count = adminMapper.selectGetBookCount();
        return count;
    }

    @Override
    public List<BackBook> selectBackBookTimeOut(Integer limit, Integer page, Date nowTime) {
        List<BackBook> list = adminMapper.selectBackBookTimeOut(limit,page,nowTime);
        return list;
    }

    @Override
    public int selectBackBookTimeOutCount(Date nowTime) {
        int count = adminMapper.selectBackBookTimeOutCount(nowTime);
        return count;
    }

    @Override
    public List<GetBook> selectGetBookTimeOut(Integer limit, Integer page, Date nowTime) {
        List<GetBook> list = adminMapper.selectGetBookTimeOut(limit,page,nowTime);
        return list;
    }

    @Override
    public int selectGetBookTimeOutCount(Date nowTime) {
        int count = adminMapper.selectGetBookTimeOutCount(nowTime);
        return count;
    }
}
