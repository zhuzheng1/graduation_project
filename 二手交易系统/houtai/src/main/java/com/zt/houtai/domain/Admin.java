package com.zt.houtai.domain;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private String admin_id;
    private String admin_name;
    private String admin_password;
    private String admin_qq;
    private String admin_phone;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_qq() {
        return admin_qq;
    }

    public void setAdmin_qq(String admin_qq) {
        this.admin_qq = admin_qq;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_qq='" + admin_qq + '\'' +
                ", admin_phone='" + admin_phone + '\'' +
                '}';
    }
}
