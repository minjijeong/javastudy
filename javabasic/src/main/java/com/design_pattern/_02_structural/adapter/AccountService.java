package com.design_pattern._02_structural.adapter;

import com.design_pattern._02_structural.adapter.security.UserDetails;
import com.design_pattern._02_structural.adapter.security.UserDetailsService;

public class AccountService implements UserDetailsService {
    public Account findAccountByUserName(String userName){
        Account account = new Account();
        account.setName(userName);
        account.setPassword(userName);
        account.setEmail(userName);
        return account;
    }

    public void createNewAccount(Account account){

    }

    public void updateAccount(Account account){

    }

    @Override
    public UserDetails loadUser(String userName) {
        return findAccountByUserName(userName);
    }
}
