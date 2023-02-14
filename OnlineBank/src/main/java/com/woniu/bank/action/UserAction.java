package com.woniu.bank.action;
import com.woniu.bank.bean.Card;
import com.woniu.bank.bean.User;
import com.woniu.bank.service.UserService;

import static com.woniu.bank.util.MyUtil.*;
public class UserAction {
    UserService userservice = new UserService();
    public void regist(){
        System.out.println("请输入姓名");
        String name = scanner.next();
        System.out.println("请输入身份证号");
        String idCard = scanner.next();
        System.out.println("请输入电话");
        String tel = scanner.next();
        System.out.println("请输入密码");
        String pwd = scanner.next();
        User user= new User(name,idCard,tel,pwd);
        Card card = userservice.regist(user);
        System.out.println("注册成功！您的银行卡信息为"+card);


    }
}
