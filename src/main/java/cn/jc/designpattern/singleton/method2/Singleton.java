package cn.jc.designpattern.singleton.method2;

/**
 * 饿汉式
 * 使用时调用 getInstance 方法，后期如有需求可直接改动方法实现即可
 */
public class Singleton {
    public static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
