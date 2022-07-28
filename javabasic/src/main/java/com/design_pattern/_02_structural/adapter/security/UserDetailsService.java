package com.design_pattern._02_structural.adapter.security;

import com.design_pattern._02_structural.adapter.security.UserDetails;

public interface UserDetailsService{
    UserDetails loadUser(String userName);
}
