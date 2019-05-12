package cn.jc.designpattern.abstractfactory.us;

import cn.jc.designpattern.abstractfactory.Dog;

public class DogUs implements Dog {
    @Override
    public void say() {
        System.out.println("american dog");
    }
}
