package cn.jc.designpattern.builderpattern1;

public interface Builder {

    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getResult();
}
