package com.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoFactory {
    public UserDao userDao(){
        UserDao dao = new UserDao(connectionMaker());
        return dao;
    }

    public ConnectionMaker connectionMaker() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return connectionMaker;
    }
}
