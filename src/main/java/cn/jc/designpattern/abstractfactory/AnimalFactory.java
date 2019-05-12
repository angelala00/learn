package cn.jc.designpattern.abstractfactory;

public interface AnimalFactory {
    /**
     * 抽象工厂方法
     * 特点与工厂方法一致：
     * 创建了一个对象
     * 返回类型为一个接口或者抽象类
     * 有多个类实现了上述抽象类型
     *
     * @param animalType
     * @return
     */
    Animal getAnimal(String animalType);
}
