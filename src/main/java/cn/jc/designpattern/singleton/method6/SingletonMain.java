package cn.jc.designpattern.singleton.method6;

public class SingletonMain {
    public static void main(String[] args) {
        System.out.println("1,程序运行到这里的时候 AnimalFactoryNorth 还没有被加载");
        String a1 = "";
        System.out.println("2,程序运行到这里的时候 AnimalFactoryNorth 被加载了，但是Singleton1里面的内部类没有被加载");
        String a2 = Singleton.someStaticProperty;
        System.out.println("3,程序运行到这里的时候Singleton1里面的内部类被加载到了");
        Singleton.getInstance();
        System.out.println("4,");
    }
}
