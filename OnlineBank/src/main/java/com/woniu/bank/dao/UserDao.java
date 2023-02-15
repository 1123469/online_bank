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
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getByTelAndPwd(String tel, String pwd) {
        String sql = "select id,name,idcard,tel,pwd from users where tel=? and pwd =?";
        Connection conn = getConnection();
        User user = null;
        try {
            user = queryRunner.query(conn,sql,new BeanHandler<>(User.class),tel,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
