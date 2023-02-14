package com.woniu.bank;

import com.woniu.bank.menu.LoginMenu;
import com.woniu.bank.menu.UnLoginMenu;
import static com.woniu.bank.util.MyUtil.*;

public class MainEnter {
    private static final  LoginMenu loginMenu = new LoginMenu();
    private static final UnLoginMenu unloginMenu = new UnLoginMenu();
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        while(true){
            if (null== loginUser ) {
                unloginMenu.showMenu();
            }else {
                loginMenu.showMenu();
            }
        }
    }
}
