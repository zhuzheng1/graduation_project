package com.cx.service;

import com.cx.domain.Book;
import com.cx.domain.MyShare;
import com.cx.domain.ShareIdVo;

import java.util.Date;
import java.util.List;

public interface ShareService {
    List<MyShare> selectMyShare(String userID, Date time);

    boolean shareBook(Book book);

    boolean share(String bookId, String userID, String shareID);

    List<ShareIdVo> selectMyShareID(String userId);

    List<MyShare> selectShareBookTimeOut(Date time, String userID);

    boolean changeShareStatus(String shareID);

    List<ShareIdVo> selectMyShareIDTimeOut(String userID);
}
