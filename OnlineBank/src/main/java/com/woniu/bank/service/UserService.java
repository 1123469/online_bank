package com.woniu.bank.service;

import com.woniu.bank.bean.Card;
import com.woniu.bank.bean.User;
import com.woniu.bank.dao.UserDao;

public class UserService {
    UserDao userDao = new UserDao();
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
        userDao.add(user);
        return  null;
    }
}
