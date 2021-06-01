package com.zt.houtai.domain;

import org.springframework.stereotype.Component;

@Component
public class Goods {

    private String goods_id;
    private String user_id;
    private String goods_image;
    private String goods_title;
    private String goods_detail;
    private String goods_type;
    private Integer goods_price;
    private String goods_place;
    private String goods_phone;
    private String goods_qq;

    public String getGoods_qq() {
        return goods_qq;
    }

    public void setGoods_qq(String goods_qq) {
        this.goods_qq = goods_qq;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public Integer getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Integer goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_place() {
        return goods_place;
    }

    public void setGoods_place(String goods_place) {
        this.goods_place = goods_place;
    }

    public String getGoods_phone() {
        return goods_phone;
    }

    public void setGoods_phone(String goods_phone) {
        this.goods_phone = goods_phone;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id='" + goods_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", goods_image='" + goods_image + '\'' +
                ", goods_title='" + goods_title + '\'' +
                ", goods_detail='" + goods_detail + '\'' +
                ", goods_type='" + goods_type + '\'' +
                ", goods_price=" + goods_price +
                ", goods_place='" + goods_place + '\'' +
                ", goods_phone='" + goods_phone + '\'' +
                '}';
    }
}
