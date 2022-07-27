package com.OOPRules.srp_ocp_Isp;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void save(User user) {
        System.out.println("save!");
    }

    public User getUserInfo(String email) {
        return  User.builder()
                .email(email)
                .pw("test")
                .build();
    }
}
