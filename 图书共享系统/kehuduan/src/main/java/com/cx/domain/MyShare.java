package com.cx.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyShare {

    private String shareBookId;

    private String shareTime;

    private String backTime;

    @Autowired
    private Book book;

    public String getShareBookId() {
        return shareBookId;
    }

    public void setShareBookId(String shareBookId) {
        this.shareBookId = shareBookId;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "MyShare{" +
                "shareBookId='" + shareBookId + '\'' +
                ", shareTime='" + shareTime + '\'' +
                ", backTime='" + backTime + '\'' +
                ", book=" + book +
                '}';
    }
}
