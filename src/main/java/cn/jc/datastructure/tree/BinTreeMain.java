package cn.jc.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinTreeMain {

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
    }
    public static void main(String[] args){
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
        BinTreeMain.printLayerBinTree(bt_a);
    }
}
