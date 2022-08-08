package com.tobyspring.dao;

public class DaoFactory {
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    // .. 다른 Dao 존재시

    private ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
