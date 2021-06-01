package com.cx.service;

import com.cx.domain.*;

import java.util.Date;
import java.util.List;

public interface AdminService {
    String login(String username, String password);

//    boolean register(Admin admin);

    List<User> selectAllUser(Integer limit, Integer page);

    List<ShareUnderReview> selectAllShareUnderReview(Integer limit, Integer page);

    ShareUnderReview selectUserShareByShareID(String shareID);

    boolean shareComplete(String shareID, String backTime);

    List<BorrowUnderReview> selectAllBorrowUnderReview(Integer limit, Integer page);

    BorrowUnderReview selectUserBorrowByBorrowID(String borrowID);

    boolean borrowComplete(String borrowID, String borrow_end_time);

    List<Book> inTheLibrary(Integer limit, Integer page);

    List<Book> lend(Integer limit, Integer page);

    int selectUserCount();

    int selectShareUnderReviewCount();

    int selectBorrowUnderReviewCount();

    int selectInTheLibraryCount();

    int selectLendCount();

    List<BackBook> selectBackBook(Integer limit, Integer page);

    int selectBackBookCount();

    List<GetBook> selectGetBook(Integer limit, Integer page);

    int selectGetBookCount();

    List<BackBook> selectBackBookTimeOut(Integer limit, Integer page, Date nowTime);

    int selectBackBookTimeOutCount(Date nowTime);

    List<GetBook> selectGetBookTimeOut(Integer limit, Integer page, Date nowTime);

    int selectGetBookTimeOutCount(Date nowTime);
}
