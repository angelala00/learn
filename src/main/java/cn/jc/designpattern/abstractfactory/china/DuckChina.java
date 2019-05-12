package cn.jc.designpattern.abstractfactory.china;

import cn.jc.designpattern.abstractfactory.Duck;

public class DuckChina implements Duck {
    @Override
    public void say() {
        System.out.println("chinese cat");
    }
}
