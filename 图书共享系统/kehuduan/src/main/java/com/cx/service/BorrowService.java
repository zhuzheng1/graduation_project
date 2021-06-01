package com.cx.service;

import com.cx.domain.Borrow;
import com.cx.domain.BorrowIdVo;
import com.cx.domain.MyBorrow;

import java.util.Date;
import java.util.List;

public interface BorrowService {
    List<MyBorrow> selectMyBorrow(String userID, Date time);

    List<BorrowIdVo> selectMyBorrowID(String userId);

    boolean borrow(Borrow borrow);

    List<MyBorrow> selectBorrowBookTimeOut(Date time, String userID);

    boolean changeBorrowStatus(String borrowID);

    List<BorrowIdVo> selectMyBorrowIDTimeOut(String userID);
}
