package com.woniu.bank.dao;

import com.woniu.bank.bean.Detail;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.woniu.bank.util.MyUtil.*;

public class DetailDao {

    public void save(Detail detail) {
        String sql = "insert into details values (null,?,?,?,?,?)";
        Connection conn = getConnection();
        try {
            queryRunner.update(conn,sql,detail.getMyCard(),detail.getOtherCard(),detail.getIncome(),detail.getAmount(),detail.getDealtime());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    public List<Detail> getDetails(int userId,int myCard, int otherCard, int income, String amount, int days) {
//        String sql = "select id,myCard,otherCard,income,amount,dealtime from details where ";
//        sql+=getCard(myCard,userId);
//        String sql1 = getOtherCard(otherCard);
//        if(!sql1.equals("")){
//            sql+=" and ";
//            sql+=sql1;
//        }
//
//        String sql2 = getIncomeSql(income);
//        if(!sql2.equals("")){
//            sql+=" and ";
//            sql+=sql2;
//        }
//
//        String sql3 = getAmount(amount);
//        sql+=" and ";
//        sql+=sql3;
//
//        String sql4 = getDaySql(days);
//        sql+=" and ";
//        sql+=sql4;
//
//
//        System.out.println(sql);
//
//
//        return null;
//    }
//
//    private String getCard(int userId,int myCard){
//        if(myCard==0){
//            return " myCard in (select id from cards where userId="+userId+") ";
//
//        }else {
//            return " myCard = "+myCard+" ";
//        }
//    }
//
//    private String getOtherCard(int otherCard){
//        if(otherCard==-1){
//            return " otherCard is null ";
//        }else if(otherCard==0){
//            return "";
//        }else{
//            return " otherCard = "+otherCard+" ";
//        }
//    }
//
//    private String getIncomeSql(int income){
//        if(income==0){
//            return " income = 0 ";
//        }else if(income==1){
//            return " income = 1 ";
//        }else {
//            return "";
//        }
//    }
//
//    private String getAmount(String amount){
//        String[] split = amount.split("-");
//        double min = Double.parseDouble(split[0]);
//        double max = Double.parseDouble(split[1]);
//        return " amount> "+min+" and amount<"+max+" ";
//    }
//
//    private  String getDaySql(int day){
//        return " dealtime >DATE_SUB(now(),interval "+day+" day) ";
//    }
public List<Detail> getDetails(int userId,int myCard, int otherCard, int income, String amount, int days) {
    String sql = "select id,myCard,otherCard,income,amount,dealtime from details where ";
    sql+=getCardSql(myCard,userId);
    String sql1 = getOtherCardSql(otherCard);
    if(!sql1.equals("")){
        sql+=sql1;
    }
    //
    String sql2 = getIncomeSql(income);
    if(!sql2.equals("")){
        sql+=sql2;
    }
    //
    String sql3 = getAmountSql(amount);
    sql+=sql3;
    //
    String daySql = getDaySql(days);
    sql+=daySql;
    //
    Connection conn = getConnection();
    List<Detail> query = null;
    try {
//        System.out.println(sql);
        query = queryRunner.query(conn, sql, new BeanListHandler<>(Detail.class));
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return query;
}

    private String getCardSql(int myCard,int userId){
        if(myCard==0){
            return " mycard in (select id from cards where userId ="+userId+" )  ";
        }else{
            return " myCard = "+myCard+" ";
        }
    }

    private String getOtherCardSql(int otherCard){
        if(otherCard==-1){
            return " and otherCard is null ";
        }else if(otherCard==0){
            return "";
        }else{
            return " and otherCard = "+otherCard+" ";
        }
    }

    private String getIncomeSql(int income){
        if(income==0){
            return " and income = 0 ";
        }else if(income==1){
            return " and income = 1 ";
        }else{
            return "";
        }
    }

    private String getAmountSql(String amount){
        String[] split = amount.split("-");
        double min = Double.parseDouble(split[0]);
        double max = Double.parseDouble(split[1]);
        return " and amount > "+min+" and amount<"+max+" ";
    }

    private String getDaySql(int day){
        return " and dealtime > DATE_SUB(now(),interval "+day+" day) ";
    }

}
