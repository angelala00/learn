package cn.jc.datastructure.exam;

import cn.jc.datastructure.tree.BinSortTree;

public class FindKthWithBinSortTree {
    private static int k = 10;
    private static int i = 0;
    private static Integer value = null;

    public void find(BinSortTree tree) {
        if (tree == null || value != null) {
            return;
        }

        find(tree.getRchild());

        if (i == k) {
            value = tree.getData();
        }

        find(tree.getLchild());
    }

    public static void main(String[] args) {
        BinSortTree a = null;
        new FindKthWithBinSortTree().find(a);
        System.out.println("result:" + value);
    }
}
