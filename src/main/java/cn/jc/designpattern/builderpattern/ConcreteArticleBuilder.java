package cn.jc.designpattern.builderpattern;

import java.util.Date;

public class ConcreteArticleBuilder implements ArticleBuilder {
    private Article article = new Article();
    @Override
    public void setTitle(String title) {
        article.setTitle(title);
    }

    @Override
    public void buildContent(String content) {
        article.setContent(content);
    }

    @Override
    public void setTime(Date date) {
        article.setTime(date);
    }

    @Override
    public Article getResultArticle() {
        return article;
    }
}
