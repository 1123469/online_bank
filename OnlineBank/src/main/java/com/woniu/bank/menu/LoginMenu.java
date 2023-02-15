package com.woniu.bank.menu;
import com.woniu.bank.action.UserAction;

import static com.woniu.bank.util.MyUtil.*;
/*
* 登录菜单
*
* */
public class LoginMenu {
    UserAction userAction = new UserAction();
    public void showMenu(){
        System.out.println("=========欢迎使用网上银行==========");
        System.out.println("1. 余额查询");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 个人中心");
        System.out.println("5. 转账汇款");
        System.out.println("6. 交易记录");
        System.out.println("7. 办新卡");
        System.out.println("8. 退出");
        System.out.println("请选择：");
        int i = scanner.nextInt();
        switch(i){
            case 1:
                System.out.println("查询");
                userAction.showBalance();
                break;
            case 2:
                userAction.saveMoney();
                break;
            case 3:
                userAction.withdrawMoney();
                break;
            case 4:
                break;
            case 5:
                userAction.transfer();
                break;
            case 6:
                showDetailMenu();
                break;
            case 7:
                userAction.createNewCard();
                break;
            case 8:
                exit();
                break;
            default:
                System.out.println("输入有误");
        }

    }

    private void showDetailMenu() {
        System.out.println("1. 所有明细");
        System.out.println("2. 条件查询");
        System.out.println("3. 返回主菜单");
        int i = scanner.nextInt();
        switch (i){
            case 1:

                break;
            case 2:
                userAction.getDetails();
                break;
            case 3:
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }

    private void exit() {
        System.out.println("1. 退出登录");
        System.out.println("2. 退出系统");
        System.out.println("3. 返回主菜单");
        int i = scanner.nextInt();
        switch (i){
            case 1:
                loginUser = null;
                System.out.println("退出成功");
                break;
            case 2:
                System.exit(0);
                break;
            case 3:
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }
}
