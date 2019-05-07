package cn.jc.designpattern.singleton.method7;

/**
 * 用枚举来实现单例，有很多优点，无需考虑线程安全问题，还可以防止反序列化重新创建对象。
 * TODO 没有搞清楚 枚举是属于懒汉式还是饿汉式
 */
public enum Singleton {
    INSTANCE;

    public void whateverMethod() {

    }
}
