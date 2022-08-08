package com.tobyspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 1. DB Connection
 * 2. SQL을 담은 Statement 또는 PreparedStatement를 만든다.
 * 3. Statement 실행
 * 4. 조회인 경우 실행결과 ResultSet으로 받아서 정보를 저장할 오브젝트에 옮겨준다.
 * 5. 작업중에 생성된 리소스는 반환
 * 6. JDBC API가 만들어내는 예외를 잡아서 처리
 */
public class UserDao {

    private ConnectionMaker connectionMaker;

    // Default 생성자
    public UserDao(){}

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
    public void setConnectionMaker(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
    public void add(User user) throws ClassNotFoundException, SQLException {
        // 1. DB Connection
        Connection c = connectionMaker.makeConnection();

        // 2. SQL을 담은 Statement 또는 PreparedStatement를 만든다.
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // 3. Statement 실행
        ps.executeUpdate();

        // 4. 조회인 경우 실행결과 ResultSet으로 받아서 정보를 저장할 오브젝트에 옮겨준다.
        // 조회가 아니므로 pass

        // 5. 작업중에 생성된 리소스는 반환
        ps.close();
        c.close();
        // 6. JDBC API가 만들어내는 예외를 잡아서 처리
        // 없음
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        // 1. DB Connection
        Connection c = connectionMaker.makeConnection();

        // 2. SQL을 담은 Statement 또는 PreparedStatement를 만든다.
        PreparedStatement ps = c.prepareStatement("select * from users where id=?");
        ps.setString(1, id);

        // 3. Statement 실행
        ResultSet rs = ps.executeQuery();

        // 4. 조회인 경우 실행결과 ResultSet으로 받아서 정보를 저장할 오브젝트에 옮겨준다.
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        // 5. 작업중에 생성된 리소스는 반환
        rs.close();
        ps.close();
        c.close();
        // 6. JDBC API가 만들어내는 예외를 잡아서 처리
        // 없음
        return user;
    }

    public void delete(String id) throws ClassNotFoundException, SQLException {
        // 1. DB Connection
        Connection c = connectionMaker.makeConnection();

        // 2. SQL을 담은 Statement 또는 PreparedStatement를 만든다.
        PreparedStatement ps = c.prepareStatement("delete from users where id=?");
        ps.setString(1, id);

        // 3. Statement 실행
        ps.executeUpdate();

        // 4. 작업중에 생성된 리소스는 반환
        ps.close();
        c.close();
        // 6. JDBC API가 만들어내는 예외를 잡아서 처리
        // 없음
    }
}
