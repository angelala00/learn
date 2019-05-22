package cn.jc.designpattern.builderpattern1;

public class BuilderDemo {
    public static void main(String[] args) {

        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println("product:" + product);
    }
}
