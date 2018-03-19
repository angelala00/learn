package cn.jc;

public class MainTest {
    public static void main(String[] args){
        Double.parseDouble("");
        ThreadLocal<String> tl1 = new ThreadLocal();
        tl1.get();
        tl1.set("");
        tl1.remove();

        ThreadLocal<String> tl2 = new ThreadLocal();
        tl2.get();
        tl2.set("");
        tl2.remove();
    }

}


