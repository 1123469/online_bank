package com.woniu.bank.dao;
import com.woniu.bank.bean.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

import static com.woniu.bank.util.MyUtil.*;
public class UserDao {
    public int add(User user){
        String sql = "INSERT INTO users values (null,?,?,?,?)";
        Connection conn = getConnection();
        try {
            Long bigId = queryRunner.insert(conn,sql,new ScalarHandler<Long>(),user.getName(),user.getIdcard(),user.getTel(),user.getPwd());
            int id = bigId.intValue();
            System.out.println(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
