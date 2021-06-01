package com.cx.service.impl;

import com.cx.dao.BookMapper;
import com.cx.domain.Book;
import com.cx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired//(required=true)
    private BookMapper bookMapper;

    @Override
    public List<Book> selectExitBook() {
        List<Book> list = bookMapper.selectAbleBorrow();
        return list;
    }

    @Override
    public boolean selectDistinct(Book book) {
        String bookID = bookMapper.selectDistinct(book);
        if(bookID!=null && !"".equals(bookID)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean selectDistinctBorrow(String bookId) {
        String bookStatus = bookMapper.selectDistinctBorrow(bookId);
        if(bookStatus != null && "在平台待借".equals(bookStatus)) {
            return true;
        }
        return false;
    }
}
