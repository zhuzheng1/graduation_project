package com.cx.service;

import com.cx.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> selectExitBook();

    boolean selectDistinct(Book book);

    boolean selectDistinctBorrow(String bookId);
}
