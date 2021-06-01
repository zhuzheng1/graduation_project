package com.cx.dao;

import com.cx.domain.Book;
import com.cx.domain.MyShare;
import com.cx.domain.Share;
import com.cx.domain.ShareIdVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ShareMapper {

    List<MyShare> selectMyShare(String userID, Date time);

    boolean shareBook(Book book);

    boolean saveMyShareRecord(Share s);

    List<ShareIdVo> selectMyShareID(String userId);

    List<MyShare> selectShareBookTimeOut(String userID, Date time);

    boolean changeShareStatus(String shareID);

    List<ShareIdVo> selectMyShareIDTimeOut(String userID);

    String selectShareEndTime(String bookID);

    boolean deleteBackBookComplete(String shareID);

    String selectBookID(String shareID);
}