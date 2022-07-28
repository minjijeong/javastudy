package com.design_pattern._02_structural.adapter;

import com.design_pattern._02_structural.adapter.security.UserDetails;

public class AccountUserDetails implements UserDetails {
    private Account account;

    public AccountUserDetails(Account account){
        this.account = account;
    }
    @Override
    public String getUserName() {
        return this.account.getName();
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }
}
