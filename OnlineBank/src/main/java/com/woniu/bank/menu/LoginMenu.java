package com.woniu.bank.menu;
import static com.woniu.bank.util.MyUtil.*;
/*
* 登录菜单
*
* */
public class LoginMenu {
    public void showMenu(){
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
                break;
            case 2:
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
