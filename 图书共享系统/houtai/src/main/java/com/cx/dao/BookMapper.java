package com.cx.dao;

import com.cx.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> selectAbleBorrow();

    String selectDistinct(Book book);

    String selectDistinctBorrow(String bookId);

    boolean updateBackBookStatus(String bookID);

    boolean deleteShareBook(String bookID);

    String selectBookStatus(String bookID);
}