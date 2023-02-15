package com.woniu.bank.bean;

import java.time.LocalDateTime;
import java.util.Date;

public class Detail {
    private int id;
    private int myCard;
    private  Integer otherCard;
    private int income;
    private double amount;
    private LocalDateTime datetime;

    public static final int INCOME = 1;
    public static final int OUTCOME = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMyCard() {
        return myCard;
    }

    public void setMyCard(int myCard) {
        this.myCard = myCard;
    }

    public Integer getOtherCard() {
        return otherCard;
    }

    public void setOtherCard(Integer otherCard) {
        this.otherCard = otherCard;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", myCard=" + myCard +
                ", otherCard=" + otherCard +
                ", income=" + income +
                ", amount=" + amount +
                ", datetime=" + datetime +
                '}';
    }
}
