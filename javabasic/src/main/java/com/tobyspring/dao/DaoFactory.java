package com.tobyspring.dao;

public class DaoFactory {
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    // .. 다른 Dao 존재시

    private ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
