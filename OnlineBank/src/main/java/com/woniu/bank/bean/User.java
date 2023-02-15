package com.woniu.bank.bean;

import java.util.List;

/*
* 用户类
* */
public class User {
    private int id;
    private String name;
    private String idcard;
    private String tel;
    private String pwd;
    private List<Card> cards;

    public User(String name, String idcard, String tel, String pwd) {
        this.name = name;
        this.idcard = idcard;
        this.tel = tel;
        this.pwd = pwd;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", pwd='" + pwd + '\'' +
                ", cards=" + cards +
                '}';
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
