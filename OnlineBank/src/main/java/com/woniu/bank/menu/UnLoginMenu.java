package com.woniu.bank.menu;

import com.woniu.bank.action.UserAction;

import static com.woniu.bank.util.MyUtil.scanner;

public class UnLoginMenu {
    UserAction useraction = new UserAction();
    public void showMenu(){
        System.out.println("==========欢迎使用网上银行==========");
        System.out.println("1. 注册");
        System.out.println("2. 登录");
        System.out.println("3. 找回密码");
        System.out.println("4. 退出");
        System.out.println("请选择：");
        int i = scanner.nextInt();
        switch(i){
            case 1:
                useraction.regist();
                break;
            case 2:
                useraction.login();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("输入有误");
        }
    }
}
