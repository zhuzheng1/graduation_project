package com.cx.dao;

import com.cx.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminMapper {

    String selectByNameAndPWD(String username, String password);

    boolean register(Admin admin);

    List<User> selectAllUser(Integer limit, Integer page);

    List<ShareUnderReview> selectAllShareUnderReview(Integer limit, Integer page);

    List<ShareUnderReview> selectUserShareByShareID(String shareID);

    boolean updateShareStatus(String shareID, String backTime);

    boolean updateBookStatus(String shareID);

    String selectShareBookID(String shareID);

    List<BorrowUnderReview> selectAllBorrowUnderReview(Integer limit, Integer page);

    List<BorrowUnderReview> selectUserBorrowByBorrowID(String borrowID);

    boolean updateBorrowStatus(String borrowID, String borrow_end_time);

    boolean updateBorrowBookStatus(String bookID);

    String selectBorrowBookID(String borrowID);

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

    List<BorrowUnderReview> aaa();

    int bbb();

    List<User> selectAccountManagement(String userID);

    List<Book> selectInTheLibrary(String bookName);

    List<Book> selectLend(String bookName);

    List<BackBook> backBookSelect(String borrowID);

    List<GetBook> getBookSelect(String shareID);

    List<BackBook> backBookTimeOutSelect(String borrowID, Date nowTime);

    List<GetBook> getBookTimeOutSelect(String shareID, Date nowTime);

    String selectIsTimeOut(String borrowID, Date nowTime);

    String selectShareIsTimeOut(String shareID, Date nowTime);
}