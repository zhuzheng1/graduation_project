package com.cx.domain;

public class BorrowIdVo {
    private String borrowId;
    private String borrowStartTime;
    private String borrowEndTime;

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

    public String getBorrowStartTime() {
        return borrowStartTime;
    }

    public void setBorrowStartTime(String borrowStartTime) {
        this.borrowStartTime = borrowStartTime;
    }
}
