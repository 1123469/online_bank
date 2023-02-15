package com.woniu.bank.bean;

public class Card {
    private int id;
    private String cpwd;
    private double balance;
    private  String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cpwd='" + cpwd + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
