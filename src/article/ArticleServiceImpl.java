package article;

import common.AbstractService;
import enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService{
    @Getter
    private final static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository repository;
    private ArticleServiceImpl() {
        this.repository = ArticleRepository.getInstance();
    }


    @Override
    public List<Article> findArticles() throws SQLException {
        return null;
    }

    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
