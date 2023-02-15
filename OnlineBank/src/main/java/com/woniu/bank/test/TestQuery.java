package com.woniu.bank.test;

import com.woniu.bank.bean.Card;
import com.woniu.bank.bean.Detail;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.woniu.bank.util.MyUtil.getConnection;
import static com.woniu.bank.util.MyUtil.queryRunner;

public class TestQuery {
    public static void main(String[] args) {
//        String sql = "select id, cpwd, balance,userid from cards where userid=?";
//        Connection conn = getConnection();
//        try {
//            List<Card> cards = queryRunner.query(conn, sql, new BeanListHandler<>(Card.class), 1);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        Connection conn = getConnection();
        String sql = "select id,myCard,otherCard,income,amount,dealtime from details where  mycard in (select id from cards where userId =1 )   and otherCard is null  and amount > 0.0 and amount<100000.0  and dealtime > DATE_SUB(now(),interval 90 day);";
        String sql1 = "select * from details";
        try {
            List<Detail> query = queryRunner.query(conn, sql1, new BeanListHandler<>(Detail.class));
            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
