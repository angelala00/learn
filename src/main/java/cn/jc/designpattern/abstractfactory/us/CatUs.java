package cn.jc.designpattern.abstractfactory.us;

import cn.jc.designpattern.abstractfactory.Cat;

public class CatUs implements Cat {
    @Override
    public void say() {
        System.out.println("american cat");
    }
}
