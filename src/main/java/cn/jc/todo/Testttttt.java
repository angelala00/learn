package cn.jc.todo;

import java.util.HashMap;
import java.util.Map;

public class Testttttt {


    private static class SingletonHolder {
        private static final Testttttt INSTANCE = new Testttttt();
    }

    private Testttttt() {
    }

    public static final Testttttt getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Map<String, String> m = new HashMap();

        String s;
        s = m.put("a","b");
        System.out.println(s);
//        s = m.put
        System.out.println(s);

    }
}







