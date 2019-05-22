package cn.jc.designpattern.builderpattern1;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("partA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("partB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("partC");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
