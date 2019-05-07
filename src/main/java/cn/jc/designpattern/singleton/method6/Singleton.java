package cn.jc.designpattern.singleton.method6;

/**
 * 静态内部类实现，针对内部类SingletonHolder来看，属于饿汉式，针对外部类Singleton来看，属于懒汉式的效果
 * 只有在调用getInstance方法的时候才会初始化内部类SingletonHolder的属性也就是单例实例
 * 由JVM帮我们保证了线程安全，JVM在初始化类的时候是不允许多线程进入的
 */
public class Singleton {
    public static String someStaticProperty = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
