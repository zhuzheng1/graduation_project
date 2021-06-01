package com.cx.dao;

import com.cx.domain.Borrow;
import com.cx.domain.BorrowIdVo;
import com.cx.domain.MyBorrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface BorrowMapper {

    List<MyBorrow> selectMyBorrow(String userID, Date time);

    List<BorrowIdVo> selectMyBorrowID(String userId);

    boolean saveBorrow(Borrow borrow);

    List<MyBorrow> selectBorrowBookTimeOut(String userID, Date time);

    boolean changeBorrowStatus(String borrowID);

    List<BorrowIdVo> selectMyBorrowIDTimeOut(String userID);

    boolean deleteBackBookComplete(String borrowID);

    String selectBookID(String borrowID);
}