package com.linus.api.user;

import lombok.Getter;

import java.sql.*;
import java.util.List;

public class UserRepository {

    @Getter
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/linusdb",
                "linus",
                "password");
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from users";
        System.out.println("sql : " + sql);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
                System.out.println();
            } while (rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }


        return null;
    }

    public String createTable() {
        String sql = "CREATE TABLE Users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    addressID VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";
        System.out.println("sql : " + sql);
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return "테이블 생성";
    }

    public String dropTable() {
        String sql = "drop table users";
        System.out.println("sql : " + sql);
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.execute();
            return "테이블 삭제 성공";
        } catch (SQLException e) {
            if ("Unknown table 'linusdb.users'".equals(e.getMessage())) {
                return "테이블이 존재하지 않습니다.";
            }
            return "테이블 삭제 실패: " + e.getMessage();
        }
    }
    }