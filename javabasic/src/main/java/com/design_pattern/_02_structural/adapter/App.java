package com.design_pattern._02_structural.adapter;

import com.design_pattern._02_structural.adapter.security.UserDetailsService;
import com.design_pattern._02_structural.adapter.security.LoginHandler;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("keesun", "keesun");
        System.out.println(login);
    }
}
