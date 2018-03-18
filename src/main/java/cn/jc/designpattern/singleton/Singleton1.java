package cn.jc.designpattern.singleton;

/**
 * 内部类实现单例模式
 * Created by fangyu on 3/17/18.
 */
public class Singleton1 {
    public static String staticProprety;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return UserSingletonHolder.INSTANCE;
    }

    private static class UserSingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }
}
