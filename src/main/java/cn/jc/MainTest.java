package cn.jc;

import cn.jc.datastructure.search.ErfenSearchB;
import cn.jc.datastructure.tree.BinTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MainTest {
    public static void main(String[] args){
        int a = testE();
        System.out.println("testE.result:a=" + a);
        ThreadLocal<String> tl1 = new ThreadLocal();
        tl1.get();
        tl1.set("");
        tl1.remove();

        ThreadLocal<String> tl2 = new ThreadLocal();
        tl2.get();
        tl2.set("");
        tl2.remove();
        BinTree bt_a = new BinTree("a");
        BinTree bt_b = new BinTree("b");
        BinTree bt_c = new BinTree("c");
        BinTree bt_d = new BinTree("d");
        BinTree bt_e = new BinTree("e");
        BinTree bt_f = new BinTree("f");
        BinTree bt_g = new BinTree("g");
        bt_a.setLchild(bt_b);
        bt_a.setRchild(bt_c);
        bt_b.setLchild(bt_d);
        bt_b.setRchild(bt_e);
        bt_c.setLchild(bt_f);
        bt_c.setRchild(bt_g);
        printLayerBinTree(bt_a);
    }

    private static int testE() {
        try {
            throw new Exception();
        } catch (Exception e){
            System.out.println("000");
            return getttt();
        } finally {
            System.out.println("111");
            return 1;
        }
    }

    public static void printLayerBinTree(BinTree bt){
        Queue<BinTree> q = new LinkedList<BinTree>();
        q.offer(bt);
        while (!q.isEmpty()) {
            BinTree b = q.poll();
            System.out.println(b.getData());
            if (b.getLchild() != null) {
                q.offer(b.getLchild());
            }
            if (b.getRchild() != null) {
                q.offer(b.getRchild());
            }
        }



        int[] a = new int[]{5, 6, 6, 9, 9, 11, 13, 15};
        System.out.println("r:" + new ErfenSearchB().findA_end(a, 6));
    }


    public static int getttt() {
        System.out.println("getttt:0");
        return 0;
    }
}


