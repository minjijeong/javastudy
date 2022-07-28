package com.design_pattern._02_structural.adapter;

import com.design_pattern._02_structural.adapter.security.UserDetails;
import lombok.Data;

@Data
public class Account implements UserDetails {
    private String name;
    private String password;
    private String email;

    @Override
    public String getUserName() {
        return this.name;
    }
}
