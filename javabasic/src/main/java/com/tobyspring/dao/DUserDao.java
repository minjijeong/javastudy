package com.tobyspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // D사 DB 커넥션 세팅
        return null;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new NUserDao();
        User user = new User();
        user.setId("D1");
        user.setName("D사멤버십");
        user.setPassword("password");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공!");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공!");

        dao.delete(user.getId());
        System.out.println(user.getId() + " 삭제 성공!");
    }
}
