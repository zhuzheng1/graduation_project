package com.cx.service.impl;

import com.cx.dao.BorrowMapper;
import com.cx.domain.Borrow;
import com.cx.domain.BorrowIdVo;
import com.cx.domain.MyBorrow;
import com.cx.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired//(required=true)
    private BorrowMapper borrowMapper;

    @Override
    public List<MyBorrow> selectMyBorrow(String userID, Date time) {

        List<MyBorrow> list = borrowMapper.selectMyBorrow(userID,time);
        return list;
    }

    @Override
    public List<BorrowIdVo> selectMyBorrowID(String userId) {
        List<BorrowIdVo> list = borrowMapper.selectMyBorrowID(userId);
        return list;
    }

    @Override
    public boolean borrow(Borrow borrow) {
        boolean flag = borrowMapper.saveBorrow(borrow);
        return flag;
    }

    @Override
    public List<MyBorrow> selectBorrowBookTimeOut(Date time, String userID) {

        List<MyBorrow> list = borrowMapper.selectBorrowBookTimeOut(userID,time);
        return list;
    }

    @Override
    public boolean changeBorrowStatus(String borrowID) {

        boolean flag = borrowMapper.changeBorrowStatus(borrowID);
        return flag;
    }

    @Override
    public List<BorrowIdVo> selectMyBorrowIDTimeOut(String userID) {
        List<BorrowIdVo> list = borrowMapper.selectMyBorrowIDTimeOut(userID);
        return list;
    }
}
