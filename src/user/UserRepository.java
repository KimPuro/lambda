package user;

import lombok.Getter;

import java.sql.*;
import java.util.List;

public class UserRepository {
    Connection connection;
    @Getter
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/linusdb",
                "linus", "password");
    }

    public String test(){
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("select * from board");
        ResultSet resultSet = pstmt.executeQuery();

        if(resultSet.next()){
            do{
            System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("writer"));
        }while(resultSet.next());
        }else{
            System.out.println("조회결과가 없습니다.");
        }

        resultSet.close();
        pstmt.close();
        connection.close();
        return null;
    }
}