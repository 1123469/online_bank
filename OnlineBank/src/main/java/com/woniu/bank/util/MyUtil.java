package com.woniu.bank.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.woniu.bank.bean.User;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class MyUtil {
    public static User loginUser;
    public static final Scanner scanner = new Scanner(System.in);
    public static final QueryRunner queryRunner = new QueryRunner();
    private static final DruidDataSource DATA_SOURCE = new DruidDataSource();
    static{
        DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
        DATA_SOURCE.setUrl("jdbc:mysql://localhost/woniu?useSSL=false");
        DATA_SOURCE.setUsername("root");
        DATA_SOURCE.setPassword("112358");

    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomPwd(){
        return new Random().nextInt(999999)+"";
    }
}
