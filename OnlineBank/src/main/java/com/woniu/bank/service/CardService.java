package com.woniu.bank.service;

import com.woniu.bank.bean.Card;
import com.woniu.bank.dao.CardDao;

public class CardService {
    CardDao cardDao = new CardDao();
    public Card getCardById(int id){
        return cardDao.getByCardId(id);
    }

}
