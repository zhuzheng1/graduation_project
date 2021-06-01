package com.cx.domain;

import org.springframework.stereotype.Component;

@Component
public class BackBook {
    private String back_borrow_id;
    private String back_borrow_start_time;
    private String back_borrow_end_time;
    private String back_borrow_username; // 还书者的用户名
    private String back_borrow_userID ;// 还书者的用户id
    private String back_borrow_bookName; // // 还书者的书籍民
    private String back_borrow_phone;//  还书者的电话号码
    private String back_borrow_s_number ; // 还书者的学号

    public String getBack_borrow_end_time() {
        return back_borrow_end_time;
    }

    public void setBack_borrow_end_time(String back_borrow_end_time) {
        this.back_borrow_end_time = back_borrow_end_time;
    }

    public String getBack_borrow_id() {
        return back_borrow_id;
    }

    public void setBack_borrow_id(String back_borrow_id) {
        this.back_borrow_id = back_borrow_id;
    }

    public String getBack_borrow_start_time() {
        return back_borrow_start_time;
    }

    public void setBack_borrow_start_time(String back_borrow_start_time) {
        this.back_borrow_start_time = back_borrow_start_time;
    }

    public String getBack_borrow_username() {
        return back_borrow_username;
    }

    public void setBack_borrow_username(String back_borrow_username) {
        this.back_borrow_username = back_borrow_username;
    }

    public String getBack_borrow_userID() {
        return back_borrow_userID;
    }

    public void setBack_borrow_userID(String back_borrow_userID) {
        this.back_borrow_userID = back_borrow_userID;
    }

    public String getBack_borrow_bookName() {
        return back_borrow_bookName;
    }

    public void setBack_borrow_bookName(String back_borrow_bookName) {
        this.back_borrow_bookName = back_borrow_bookName;
    }

    public String getBack_borrow_phone() {
        return back_borrow_phone;
    }

    public void setBack_borrow_phone(String back_borrow_phone) {
        this.back_borrow_phone = back_borrow_phone;
    }

    public String getBack_borrow_s_number() {
        return back_borrow_s_number;
    }

    public void setBack_borrow_s_number(String back_borrow_s_number) {
        this.back_borrow_s_number = back_borrow_s_number;
    }
}
