package com.linus.api.crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseHelper {
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/linusdb";
        String user = "linus";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    public void insertBugsData(Map<String, Map<String, String>> data) {
        String query = "INSERT INTO bugs_chart (title, artist, musicRank) VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (Map.Entry<String, Map<String, String>> entry : data.entrySet()) {
                pstmt.setString(1, entry.getKey());
                pstmt.setString(2, entry.getValue().get("가수"));
                pstmt.setString(3, entry.getValue().get("순위"));

                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }    public void insertMelonData(Map<String, Map<String, String>> data) {
        String query = "INSERT INTO melon_chart (title, artist, musicRank) VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (Map.Entry<String, Map<String, String>> entry : data.entrySet()) {
                pstmt.setString(1, entry.getKey());
                pstmt.setString(2, entry.getValue().get("가수"));
                pstmt.setString(3, entry.getValue().get("순위"));

                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}