package cn.jc.designpattern.factorymethod;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AnimalFactoryDemo {
    public static void main(String[] args) {
        AnimalFactory af = new AnimalFactory();
        Animal cat = af.getAnimal("cat");
        cat.say();
        Animal dog = af.getAnimal("dog");
        dog.say();
        Animal duck = af.getAnimal("duck");
        duck.say();
    }

    /**
     * JDK中工厂方法模式，iterator方法
     * 来自《设计模式Java手册》
     * @param args
     */
    public static void main2(String[] args) {
        List list = Arrays.asList(new String[]{"funasdf", "rocsdfd", "sparkkkasf"});
        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
