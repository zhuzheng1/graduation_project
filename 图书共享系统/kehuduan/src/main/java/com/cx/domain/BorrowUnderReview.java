package com.cx.domain;

import org.springframework.stereotype.Component;

@Component
public class BorrowUnderReview {
    private String borrow_id;
    private String borrow_start_time;
    private String borrow_username; // 借阅者的用户名
    private String borrow_userID ;// 借阅者的用户id
    private String borrow_bookName; // // 借阅者的书籍民
    private String borrow_phone;//  借阅者的电话号码
    private String borrow_s_number ; // 借阅者的学号

    public String getBorrow_username() {
        return borrow_username;
    }

    public void setBorrow_username(String borrow_username) {
        this.borrow_username = borrow_username;
    }

    public String getBorrow_userID() {
        return borrow_userID;
    }

    public void setBorrow_userID(String borrow_userID) {
        this.borrow_userID = borrow_userID;
    }

    public String getBorrow_bookName() {
        return borrow_bookName;
    }

    public void setBorrow_bookName(String borrow_bookName) {
        this.borrow_bookName = borrow_bookName;
    }

    public String getBorrow_phone() {
        return borrow_phone;
    }

    public void setBorrow_phone(String borrow_phone) {
        this.borrow_phone = borrow_phone;
    }

    public String getBorrow_s_number() {
        return borrow_s_number;
    }

    public void setBorrow_s_number(String borrow_s_number) {
        this.borrow_s_number = borrow_s_number;
    }

    public String getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(String borrow_id) {
        this.borrow_id = borrow_id;
    }

    public String getBorrow_start_time() {
        return borrow_start_time;
    }

    public void setBorrow_start_time(String borrow_start_time) {
        this.borrow_start_time = borrow_start_time;
    }
}
