package com.woniu.bank.service;

import com.woniu.bank.bean.Card;
import com.woniu.bank.bean.Detail;
import com.woniu.bank.bean.User;
import com.woniu.bank.dao.CardDao;
import com.woniu.bank.dao.DetailDao;
import com.woniu.bank.dao.UserDao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.woniu.bank.util.MyUtil.*;

public class UserService {
    UserDao userDao = new UserDao();
    CardDao cardDao = new CardDao();
    DetailDao detailDao = new DetailDao();
    /**
     * 注册一个用户并同时生成一张银行卡返回生成的银行卡账号
     * @param user
     * @return
     */
    public Card regist(User user){
        /*
        * 添加user对象到数据库
        * 为该用户开卡
        * */
        int id = userDao.add(user);
        return  createNewCard(id);
    }

    public Card createNewCard(int userId){
        Card  card = new Card();
        card.setCpwd(getRandomPwd());
        cardDao.add(userId,card);
        return  card;


    }

    public User getByTelAndPwd(String tel, String pwd) {
        User user = userDao.getByTelAndPwd(tel,pwd);
        System.out.println(user);
        if(null!=user){
            List<Card>cards = cardDao.getByUserId(user.getId());
            user.setCards(cards);
        }
        return user;
    }

    public void saveMoney(Card card, double amount) {
        card.setBalance(card.getBalance()+amount);
        cardDao.update(card);
        Detail detail = new Detail();
        detail.setAmount(amount);
        detail.setDealtime(Timestamp.valueOf(LocalDateTime.now()));
        detail.setMyCard(card.getId());
        detail.setIncome(Detail.INCOME);
        ;detailDao.save(detail);
        System.out.println("存款成功！");
    }


    public void withdrawMoney(Card card, double amount) {
        card.setBalance(card.getBalance()-amount);
        cardDao.update(card);
        Detail detail = new Detail();
        detail.setIncome(Detail.OUTCOME);
        detail.setDealtime(Timestamp.valueOf(LocalDateTime.now()));
        detail.setAmount(amount);
        detail.setMyCard(card.getId());
        detailDao.save(detail);
        System.out.println("取款成功！");
    }

    public void transfer(Card card, Card otherCard, double amount) {
        card.setBalance(card.getBalance()-amount);
        otherCard.setBalance(otherCard.getBalance()+amount);
        cardDao.update(card);
        cardDao.update(otherCard);
        // 个人明细
        Detail myDetail = new Detail();
        myDetail.setAmount(amount);
        myDetail.setDealtime(Timestamp.valueOf(LocalDateTime.now()));
        myDetail.setMyCard(card.getId());
        myDetail.setIncome(Detail.OUTCOME);
        myDetail.setOtherCard(otherCard.getId());
        ;detailDao.save(myDetail);
        // 对方明细
        Detail otherDetail = new Detail();
        otherDetail.setAmount(amount);
        otherDetail.setDealtime(Timestamp.valueOf(LocalDateTime.now()));
        otherDetail.setMyCard(otherCard.getId());
        otherDetail.setIncome(Detail.INCOME);
        myDetail.setOtherCard(card.getId());
        detailDao.save(otherDetail);
    }

    public List<Detail> getDetails(int userId,int myCard, int otherCard, int income, String amount, int days) {
        return detailDao.getDetails(userId,myCard,otherCard,income,amount,days);
    }

    /*
    * 条件查询
    * */

}
