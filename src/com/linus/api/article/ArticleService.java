package com.linus.api.article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {
    List<Article> findArticles() throws SQLException;
}
