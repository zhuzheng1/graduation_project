package com.cx.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBorrow {

    private String borrowId;

    private String borrowStartTime;

    private String borrowEndTime;

    @Autowired
    private Book book;


    public String getBorrowStartTime() {
        return borrowStartTime;
    }

    public void setBorrowStartTime(String borrowStartTime) {
        this.borrowStartTime = borrowStartTime;
    }

    public String getBorrowEndTime() {
        return borrowEndTime;
    }

    public void setBorrowEndTime(String borrowEndTime) {
        this.borrowEndTime = borrowEndTime;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "MyBorrow{" +
                "borrowId='" + borrowId + '\'' +
                ", borrowStartTime=" + borrowStartTime +
                ", borrowEndTime=" + borrowEndTime +
                ", book=" + book +
                '}';
    }
}
