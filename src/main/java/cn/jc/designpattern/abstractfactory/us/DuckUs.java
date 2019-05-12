package cn.jc.designpattern.abstractfactory.us;

import cn.jc.designpattern.abstractfactory.Duck;

public class DuckUs implements Duck {
    @Override
    public void say() {
        System.out.println("american duck");
    }
}
