package com.woniu.bank.dao;

import com.woniu.bank.bean.Detail;

import java.sql.Connection;
import java.sql.SQLException;

import static com.woniu.bank.util.MyUtil.*;

public class DetailDao {

    public void save(Detail detail) {
        String sql = "insert into details values (null,?,?,?,?,?)";
        Connection conn = getConnection();
        try {
            queryRunner.update(conn,sql,detail.getMyCard(),detail.getOtherCard(),detail.getIncome(),detail.getAmount(),detail.getDatetime());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
