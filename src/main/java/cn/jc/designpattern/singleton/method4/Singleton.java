package cn.jc.designpattern.singleton.method4;

/**
 * 懒汉式，使用时才初始化
 * 线程安全，方法加锁，效率低
 */
public class Singleton {
    public static Singleton instance = null;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
