package com.woniu.bank.dao;

import com.woniu.bank.bean.Card;
import com.woniu.bank.bean.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static  com.woniu.bank.util.MyUtil.*;

public class CardDao {
    public void add(int id,Card card){
        String sql = "insert into cards values (null,?,?,?)";
        Connection conn = getConnection();
        try{
            Long cardId = queryRunner.insert(conn,sql,new ScalarHandler<Long>(),card.getCpwd(),card.getBalance(),id);
            card.setId(cardId.intValue());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Card> getByUserId(int id) {
        String sql = "select id, cpwd, balance,userid from cards where userid=?";
        Connection conn = getConnection();
        try {
            List<Card> cards = queryRunner.query(conn, sql, new BeanListHandler<>(Card.class), id);
            return cards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Card card) {
        String sql = "update cards set balance=?, cpwd=? where id=?";
        Connection conn = getConnection();
        try {
            queryRunner.update(conn,sql,card.getBalance(),card.getCpwd(),card.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public Card getByCardId(int id) {
        String sql = "select id, cpwd, balance from cards where id =?";
        Connection conn = getConnection();
        Card card = null;
        try {
            card = queryRunner.query(conn,sql,new BeanHandler<Card>(Card.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return card;
    }
}
