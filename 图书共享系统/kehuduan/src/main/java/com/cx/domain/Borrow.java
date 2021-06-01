package com.cx.domain;

import org.springframework.stereotype.Component;

@Component
public class Borrow {
    private String borrowId;

    private String userId;

    private String bookId;

    private String borrowStartTime;

    private String borrowEndTime;

    private Integer borrowStatus;

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

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
}