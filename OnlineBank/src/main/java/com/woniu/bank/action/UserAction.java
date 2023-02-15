package com.woniu.bank.action;
import com.woniu.bank.bean.Card;
import com.woniu.bank.bean.Detail;
import com.woniu.bank.bean.User;
import com.woniu.bank.service.CardService;
import com.woniu.bank.service.UserService;

import java.util.List;

import static com.woniu.bank.util.MyUtil.*;
public class UserAction {
    UserService userservice = new UserService();
    CardService cardService = new CardService();

    public void regist() {
        System.out.println("请输入姓名");
        String name = scanner.next();
        System.out.println("请输入身份证号");
        String idCard = scanner.next();
        System.out.println("请输入电话");
        String tel = scanner.next();
        System.out.println("请输入密码");
        String pwd = scanner.next();
        User user = new User(name, idCard, tel, pwd);
        Card card = userservice.regist(user);
        System.out.println("注册成功！您的银行卡信息为" + card);


    }

    public void login() {
        System.out.println("请输入电话");
        String tel = scanner.next();
        System.out.println("请输入密码");
        String pwd = scanner.next();
        User user = userservice.getByTelAndPwd(tel, pwd);
        if (user != null) {
            System.out.println("登陆成功！欢迎您！" + user.getName());
            loginUser = user;
        } else {
            System.out.println("信息有误！");
        }

    }

    public void showBalance() {
        for (Card card : loginUser.getCards()) {
            System.out.println("卡号:" + card.getId() + "， 余额" + card.getBalance());
        }
    }

    public void createNewCard() {
        Card newCard = userservice.createNewCard(loginUser.getId());
        loginUser.getCards().add(newCard);
        System.out.println("办卡成功!您的银行卡信息为" + newCard);

    }
    public Card getMyCard(){
        System.out.println("请输入卡号");
        int id = scanner.nextInt();
        Card card=null;
        for (Card loginUserCard : loginUser.getCards()) {
            if(loginUserCard.getId()==id){
                card = loginUserCard;
                break;
            }
        }
        return card;
    }

    public void saveMoney() {
        Card card = getMyCard();
        if(card==null){
            System.out.println("卡号有误");
            return;
        }
        System.out.println("请输入金额");
        double amount = scanner.nextDouble();
        userservice.saveMoney(card,amount);
    }

    public void withdrawMoney() {
        Card card = getMyCard();
        if(card==null){
            System.out.println("卡号有误");
            return;
        }
        System.out.println("请输入取款密码");
        String cpwd = scanner.next();
        if(!cpwd.equals(card.getCpwd())){
            System.out.println("取款密码有误");
            return;
        }
        System.out.println("请输入取款金额");
        double amount = scanner.nextDouble();
        if(amount>card.getBalance()){
            System.out.println("余额不足");
            return;
        }
        userservice.withdrawMoney(card,amount);
    }


    public void transfer() {
        Card card= getMyCard();
        if(card==null){
            System.out.println("卡号有误");
            return;
        }
        // 对方卡
        System.out.println("请输入对方卡号");
        int cardId = scanner.nextInt();
        Card otherCard = cardService.getCardById(cardId);
        if (otherCard == null) {
            System.out.println("对方卡号不存在！");
            return;
        }else{
            System.out.println("请输入转账金额");
            double amount = scanner.nextDouble();
            if(amount>card.getBalance()){
                System.out.println("余额不足");
                return;
            }
            System.out.println("请输入取款密码");
            String cpwd = scanner.next();
            if(!cpwd.equals((card.getCpwd()))){
                System.out.println("取款密码不正确");
                return;
            }

            userservice.transfer(card,otherCard,amount);
            System.out.println("转账成功！");
        }
    }

    public void getDetails(){
        System.out.println("要查询的账号（所有账号输入0）");
        int myCard = scanner.nextInt();
        System.out.println("要查询的账号（所有账号输入0,如果要查询存取款记录输入-1）");
        int otherCard = scanner.nextInt();
        System.out.println("支出(0)/收入(1)/所有(2)");
        int income = scanner.nextInt();
        System.out.println("请输入交易金额区间(10-100):");
        String amount =scanner.next();
        System.out.println("查过去多少天的明细？");
        int days = scanner.nextInt();
        List<Detail> details = userservice.getDetails(loginUser.getId(),myCard,otherCard,income,amount,days);
        for (Detail detail : details) {
            System.out.println("我的卡号\t对方卡号\t收支\t交易金额\t交易时间");
            System.out.println(detail.getMyCard()+"\t"+
                    detail.getOtherCard()+"\t"+detail.getIncome()+"\t"+detail.getAmount()+"\t"+detail.getDealtime()
                    );
        }

    }
}
