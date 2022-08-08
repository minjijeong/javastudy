package com.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker{
    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMaker connectionMaker){
        this.realConnectionMaker = connectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        // super class 구현 내용 처리
        return realConnectionMaker.makeConnection();
    }

    public int getCounter(){
        return this.counter;
    }
}
