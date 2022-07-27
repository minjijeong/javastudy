package com.OOPRules.SRP;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void save(User user) {
        System.out.println("save!");
    }
}
