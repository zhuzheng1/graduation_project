package com.cx.service.impl;

import com.cx.dao.ShareMapper;
import com.cx.domain.Book;
import com.cx.domain.MyShare;
import com.cx.domain.Share;
import com.cx.domain.ShareIdVo;
import com.cx.service.ShareService;
import com.cx.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired//(required=true)
    private ShareMapper shareMapper;

    @Override
    public List<MyShare> selectMyShare(String userID, Date time) {
        List<MyShare> list = shareMapper.selectMyShare(userID,time);
        return list;
    }

    @Override
    public boolean shareBook(Book book) {
        boolean flag = shareMapper.shareBook(book);
        return flag;
    }

    @Override
    public boolean share(String bookId, String userID, String shareID) {
        Share s = new Share();
        s.setShareBookId(shareID);
        s.setBookId(bookId);
        s.setUserId(userID);
        s.setShareTime(DateTimeUtil.getSysTime());
        s.setShareStatus(0);
        boolean flag = shareMapper.saveMyShareRecord(s);

        return flag;
    }

    @Override
    public List<ShareIdVo> selectMyShareID(String userId) {
        List<ShareIdVo> list = shareMapper.selectMyShareID(userId);
        return list;
    }

    @Override
    public List<MyShare> selectShareBookTimeOut(Date time, String userID) {
        List<MyShare> list = shareMapper.selectShareBookTimeOut(userID,time);
        return list;
    }

    @Override
    public boolean changeShareStatus(String shareID) {
        boolean flag = shareMapper.changeShareStatus(shareID);
        return flag;
    }

    @Override
    public List<ShareIdVo> selectMyShareIDTimeOut(String userID) {
        List<ShareIdVo> list = shareMapper.selectMyShareIDTimeOut(userID);
        return list;
    }
}
