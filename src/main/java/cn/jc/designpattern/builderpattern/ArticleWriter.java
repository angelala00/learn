package cn.jc.designpattern.builderpattern;

import java.util.Date;

public class ArticleWriter {

    private ArticleBuilder builder;

    public ArticleWriter(ArticleBuilder builder) {
        this.builder = builder;
    }

    public Article construct() {
        builder.setTitle("");
        builder.buildContent("");
        builder.setTime(new Date());
        return builder.getResultArticle();
    }
}
