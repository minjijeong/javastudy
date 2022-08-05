package com.tobyspring.dao;

import java.sql.SQLException;

public class UserDoaTest {

    public static void main(String[] args) {
        UserDoaTest userDoaTest = new UserDoaTest();
        UserDao dao = new UserDao(new DConnectionMaker());
        User user = new User();
        user.setId("D1");
        user.setName("D사멤버십");
        user.setPassword("password");

        // 데이타 처리
        userDoaTest.processData(userDoaTest, user, dao);

        dao = new UserDao(new NConnectionMaker());
        user = new User();
        user.setId("N1");
        user.setName("N사멤버십");
        user.setPassword("password2");

        // 데이타처리
        userDoaTest.processData(userDoaTest, user, dao);

    }

    /**
     * 데이터 CRUD
     * 중복 처리 영역
     * - 메소드 분리
     */
    private void processData(UserDoaTest userDoaTest, User user, UserDao dao){
        try {
            // 등록
            userDoaTest.add(user, dao);
            // 조회
            userDoaTest.get(user.getId(), dao);
            // 삭제
            userDoaTest.delete(user.getId(),dao);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 사용자 등록
     */
    private void add(User user, UserDao dao) throws SQLException, ClassNotFoundException {
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공!");
    }

    /**
     * 사용자 조회
     */
    private void get(String userId, UserDao dao) throws SQLException, ClassNotFoundException {
        User searchUser = dao.get(userId);
        System.out.println(searchUser.getName());
        System.out.println(searchUser.getPassword());
        System.out.println(searchUser.getId() + " 조회 성공!");
    }

    /**
     * 사용자 삭제
     */
    private void delete(String userId, UserDao dao) throws SQLException, ClassNotFoundException {
        dao.delete(userId);
        System.out.println(userId + " 삭제 성공!");
    }
}
