package com.woniu.bank.test;

import com.woniu.bank.bean.Card;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.woniu.bank.util.MyUtil.getConnection;
import static com.woniu.bank.util.MyUtil.queryRunner;

public class TestQuery {
    public static void main(String[] args) {
        String sql = "select id, cpwd, balance,userid from cards where userid=?";
        Connection conn = getConnection();
        try {
            List<Card> cards = queryRunner.query(conn, sql, new BeanListHandler<>(Card.class), 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
