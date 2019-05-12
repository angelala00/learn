package cn.jc.designpattern.factorymethod;

public class AnimalFactory {
    /**
     * 此方法为工厂方法模式，
     * 特点为：
     * 创建了一个对象
     * 返回类型为一个接口或者抽象类
     * 有多个类实现了上述抽象类型
     * @param animalType
     * @return
     */
    public Animal getAnimal(String animalType) {
        if ("dog".equals(animalType)) {
            return new Dog();
        } else if ("cat".equals(animalType)) {
            return new Cat();
        } else if ("duck".equals(animalType)) {
            return new Duck();
        } else {
            return null;
        }
    }
}
