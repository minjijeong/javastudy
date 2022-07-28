package com.design_pattern._02_structural.adapter.security;

public class LoginHandler {
    UserDetailsService userDetailsService;

    public LoginHandler(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    public String login(String userName, String password){
        UserDetails userDetails = userDetailsService.loadUser(userName);
        if(userDetails.getPassword().equals(password)){
            return userDetails.getUserName();
        }else{
            throw new IllegalArgumentException();
        }
    }
}
