package cn.jc.designpattern.singleton.method5;

/**
 * 懒汉式，使用时才初始化
 * 线程安全，代码块加锁，效率高，
 */
public class Singleton {
    /**
     * 这里如果不加volatile声明，可能会因为JVM对指令重排导致异常
     */
    public static volatile Singleton instance = null;

    private Singleton() {
    }

    /**
     * 这里如果只判断里层，那和方法加锁一样了，如果只判断外层，那线程安全的问题没有解决
     * 这种方案可能在实例初始化时，如果遇到多线程问题，会有资源竞争，
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
