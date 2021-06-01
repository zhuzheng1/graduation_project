package com.cx.service.impl;

import com.cx.dao.AdminMapper;
import com.cx.dao.BookMapper;
import com.cx.dao.BorrowMapper;
import com.cx.dao.ShareMapper;
import com.cx.domain.*;
import com.cx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BorrowMapper borrowMapper;
    @Autowired
    ShareMapper shareMapper;

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
    public List<ShareUnderReview> selectUserShareByShareID(String shareID) {
        List<ShareUnderReview> list = adminMapper.selectUserShareByShareID(shareID);
        return list;
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
    public List<BorrowUnderReview> selectUserBorrowByBorrowID(String borrowID) {
        List<BorrowUnderReview> list = adminMapper.selectUserBorrowByBorrowID(borrowID);
        return list;
    }

    @Transactional
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
    public String selectShareEndTime(String borrowID, String endTime) {
        //借阅时间是否符合
        String bookID = borrowMapper.selectBookID(borrowID);
        String time = shareMapper.selectShareEndTime(bookID);
        if(time != null) {
            //借阅时间超时
            if(endTime.compareTo(time) > 0) {
                return time;
            }
        }
        return null;
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

    @Override
    public List<BorrowUnderReview> aaa() {
        List<BorrowUnderReview> list = adminMapper.aaa();
        return list;
    }

    @Override
    public int bbb() {
        int count = adminMapper.bbb();
        return count;
    }

    @Override
    public List<User> selectAccountManagement(String userID) {
        List<User> list = adminMapper.selectAccountManagement(userID);
        return list;
    }

    @Override
    public List<Book> selectInTheLibrary(String bookName) {
        List<Book> list = adminMapper.selectInTheLibrary(bookName);
        return list;
    }

    @Override
    public List<Book> selectLend(String bookName) {
        List<Book> list = adminMapper.selectLend(bookName);
        return list;
    }

    @Override
    public List<BackBook> backBookSelect(String borrowID) {
        List<BackBook> list = adminMapper.backBookSelect(borrowID);
        return list;
    }

    @Override
    public List<GetBook> getBookSelect(String shareID) {
        List<GetBook> list = adminMapper.getBookSelect(shareID);
        return list;
    }

    @Override
    public List<BackBook> backBookTimeOutSelect(String borrowID, Date nowTime) {
        List<BackBook> list = adminMapper.backBookTimeOutSelect(borrowID,nowTime);
        return list;
    }

    @Override
    public List<GetBook> getBookTimeOutSelect(String shareID, Date nowTime) {
        List<GetBook> list = adminMapper.getBookTimeOutSelect(shareID,nowTime);
        return list;
    }

    @Transactional
    @Override
    public boolean backBookComplete(String borrowID, String nowTime, Date time) {
        //还书是否超时
        String bookID = null;
        boolean flag = false;
        bookID = adminMapper.selectIsTimeOut(borrowID,time);
        if(bookID != null) {
            //还书没有超时
            flag = bookMapper.updateBackBookStatus(bookID);
        }else {
            //还书超时
            String shareEndTime = shareMapper.selectShareEndTime(bookID);
            if(nowTime.compareTo(shareEndTime) < 0) {
                //还书时间没有超过分享结束时间
                flag = bookMapper.updateBackBookStatus(bookID);
            }
        }
        if(flag) {
            flag = borrowMapper.deleteBackBookComplete(borrowID);
        }else {
            return false;
        }
        return flag;
    }

    @Override
    public boolean getBookComplete(String shareID, Date nowTime) {
        //取书是否超时
        String bookID = null;
        boolean flag = false;
        bookID = adminMapper.selectShareIsTimeOut(shareID,nowTime);
        if(bookID != null) {
            //取书没有超时(提前取书)
            String bookStatus = bookMapper.selectBookStatus(bookID);
            if("借出".equals(bookStatus) || bookStatus==null) {
                return false;
            }
        }else {
            //超时
            bookID = shareMapper.selectBookID(shareID);
            //删除书籍
            if(bookID == null) {
                return false;
            }
        }
        flag = bookMapper.deleteShareBook(bookID);
        if(flag) {
            flag = shareMapper.deleteBackBookComplete(shareID);
        }else {
            return false;
        }
        return flag;
    }
}
