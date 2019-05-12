package cn.jc.designpattern.abstractfactory.china;

import cn.jc.designpattern.abstractfactory.Cat;

public class CatChina implements Cat {
    @Override
    public void say() {
        System.out.println("chinese duck");
    }
}
