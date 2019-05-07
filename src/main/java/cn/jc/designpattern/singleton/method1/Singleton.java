package cn.jc.designpattern.singleton.method1;

/**
 * 饿汉式
 * 使用时直接使用静态变量，理念不好，不利于扩展
 */
public class Singleton {
    /**
     * 初始化动作写到静态代码块中是一样的效果
     */
    public static Singleton instance = new Singleton();

    private Singleton() {
    }
}
