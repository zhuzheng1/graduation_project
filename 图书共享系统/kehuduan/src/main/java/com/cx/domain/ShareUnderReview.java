package com.cx.domain;

import org.springframework.stereotype.Component;

@Component
public class ShareUnderReview {
    private String share_book_id;
    private String share_time;
    private String share_username;
    private String share_userID;
    private String share_bookName;
    private String share_phone;
    private String share_s_number;

    public String getShare_username() {
        return share_username;
    }

    public void setShare_username(String share_username) {
        this.share_username = share_username;
    }

    public String getShare_userID() {
        return share_userID;
    }

    public void setShare_userID(String share_userID) {
        this.share_userID = share_userID;
    }

    public String getShare_bookName() {
        return share_bookName;
    }

    public void setShare_bookName(String share_bookName) {
        this.share_bookName = share_bookName;
    }

    public String getShare_phone() {
        return share_phone;
    }

    public void setShare_phone(String share_phone) {
        this.share_phone = share_phone;
    }

    public String getShare_s_number() {
        return share_s_number;
    }

    public void setShare_s_number(String share_s_number) {
        this.share_s_number = share_s_number;
    }

    public String getShare_book_id() {
        return share_book_id;
    }

    public void setShare_book_id(String share_book_id) {
        this.share_book_id = share_book_id;
    }

    public String getShare_time() {
        return share_time;
    }

    public void setShare_time(String share_time) {
        this.share_time = share_time;
    }
}
