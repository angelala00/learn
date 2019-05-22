package cn.jc.designpattern.builderpattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        ArticleBuilder carBuilder = new ConcreteArticleBuilder();
        ArticleWriter cd = new ArticleWriter(carBuilder);
        Article car = cd.construct();
        System.out.println(car);
    }
}
