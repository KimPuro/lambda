package com.linus.api.board;

import com.linus.api.article.Article;

import java.util.List;

public interface BoardService {
    List<Article> findArticles();

}
