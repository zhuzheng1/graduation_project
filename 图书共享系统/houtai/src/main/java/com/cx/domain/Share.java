package com.cx.domain;

import org.springframework.stereotype.Component;

@Component
public class Share {
    private String shareBookId;

    private String userId;

    private String bookId;

    private String shareTime;

    private String backTime;

    private Integer shareStatus;

    public Integer getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(Integer shareStatus) {
        this.shareStatus = shareStatus;
    }

    public String getShareBookId() {
        return shareBookId;
    }

    public void setShareBookId(String shareBookId) {
        this.shareBookId = shareBookId;
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

    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }
}