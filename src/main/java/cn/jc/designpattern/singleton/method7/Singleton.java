package cn.jc.designpattern.singleton.method7;

/**
 * 用枚举来实现单例，有很多优点，无需考虑线程安全问题，还可以防止反序列化重新创建对象。
 * 枚举来作为单例的实现方案最初看到是在EffactiveJava中提出的，但没有被普遍使用该方案
 * 个人认为原因，枚举出来的比较晚，大家不是很熟悉，枚举是属于懒汉式
 * 对枚举的解读参考文章：https://www.cnblogs.com/kailejun/p/6624471.html
 */
public enum Singleton {
    INSTANCE;

    public void someMethod() {

    }
}
