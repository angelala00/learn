package cn.jc.designpattern.builderpattern;

import java.util.Date;

public interface ArticleBuilder {
    void setTitle(String title);

    void buildContent(String title);

    void setTime(Date date);

    Article getResultArticle();
}
