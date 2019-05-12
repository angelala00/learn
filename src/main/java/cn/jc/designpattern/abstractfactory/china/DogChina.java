package cn.jc.designpattern.abstractfactory.china;

import cn.jc.designpattern.abstractfactory.Dog;

public class DogChina implements Dog {
    @Override
    public void say() {
        System.out.println("chinese dog");
    }
}
