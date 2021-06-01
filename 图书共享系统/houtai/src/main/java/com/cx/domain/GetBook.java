package com.cx.domain;

import org.springframework.stereotype.Component;

@Component
public class GetBook {
    private String get_share_book_id;
    private String get_share_time;
    private String get_back_time;
    private String get_share_username;
    private String get_share_userID;
    private String get_share_bookName;
    private String get_share_phone;
    private String get_share_s_number;

    public String getGet_back_time() {
        return get_back_time;
    }

    public void setGet_back_time(String get_back_time) {
        this.get_back_time = get_back_time;
    }

    public String getGet_share_book_id() {
        return get_share_book_id;
    }

    public void setGet_share_book_id(String get_share_book_id) {
        this.get_share_book_id = get_share_book_id;
    }

    public String getGet_share_time() {
        return get_share_time;
    }

    public void setGet_share_time(String get_share_time) {
        this.get_share_time = get_share_time;
    }

    public String getGet_share_username() {
        return get_share_username;
    }

    public void setGet_share_username(String get_share_username) {
        this.get_share_username = get_share_username;
    }

    public String getGet_share_userID() {
        return get_share_userID;
    }

    public void setGet_share_userID(String get_share_userID) {
        this.get_share_userID = get_share_userID;
    }

    public String getGet_share_bookName() {
        return get_share_bookName;
    }

    public void setGet_share_bookName(String get_share_bookName) {
        this.get_share_bookName = get_share_bookName;
    }

    public String getGet_share_phone() {
        return get_share_phone;
    }

    public void setGet_share_phone(String get_share_phone) {
        this.get_share_phone = get_share_phone;
    }

    public String getGet_share_s_number() {
        return get_share_s_number;
    }

    public void setGet_share_s_number(String get_share_s_number) {
        this.get_share_s_number = get_share_s_number;
    }

    @Override
    public String toString() {
        return "GetBook{" +
                "get_share_book_id='" + get_share_book_id + '\'' +
                ", get_share_time='" + get_share_time + '\'' +
                ", get_back_time='" + get_back_time + '\'' +
                ", get_share_username='" + get_share_username + '\'' +
                ", get_share_userID='" + get_share_userID + '\'' +
                ", get_share_bookName='" + get_share_bookName + '\'' +
                ", get_share_phone='" + get_share_phone + '\'' +
                ", get_share_s_number='" + get_share_s_number + '\'' +
                '}';
    }
}
