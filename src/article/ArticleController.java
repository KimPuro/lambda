package article;

public class ArticleController {
    ArticleServiceImpl service;
    public ArticleController() {
        this.service = ArticleServiceImpl.getInstance();
    }

}