package cn.jc.designpattern.singleton.method3;

/**
 * 懒汉式，使用时才初始化
 * 线程不安全，单线程环境下可用
 */
public class Singleton {
    public static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
