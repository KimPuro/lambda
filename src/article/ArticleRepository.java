package article;

import lombok.Getter;

import java.sql.*;
import java.util.List;

public class ArticleRepository {
    Connection conn;
    private ArticleRepository() throws SQLException {
        this.conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/linusdb",
                "linus", "password");
    }
    public List<?> findArticles() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select * from Articles");
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
        conn.close();
        return null;
    }

}