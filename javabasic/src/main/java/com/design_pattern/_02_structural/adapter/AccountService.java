package com.design_pattern._02_structural.adapter;

public class AccountService {
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

}
