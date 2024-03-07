package article;

import lombok.Getter;
import user.User;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{
    @Getter
    private static final ArticleServiceImpl instance = new ArticleServiceImpl();
    ArticleRepository repo;

    @Override
    public List<Article> findArticles() throws SQLException {
        return (List<Article>) repo.findArticles();
    }
}
