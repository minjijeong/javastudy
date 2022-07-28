package com.design_pattern._02_structural.adapter;

import com.design_pattern._02_structural.adapter.security.UserDetails;
import com.design_pattern._02_structural.adapter.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

    AccountService accountService;

    public AccountUserDetailsService(AccountService accountService){
        this.accountService = accountService;
    }
    @Override
    public UserDetails loadUser(String userName) {
        Account accountByUserName = accountService.findAccountByUserName(userName);
        return new AccountUserDetails(accountByUserName);
    }
}
