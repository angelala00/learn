package cn.jc.datastructure.tree;

public class BinSortTree {
    private int data;
    private BinSortTree rchild;
    private BinSortTree lchild;

    public BinSortTree(int data) {
        this.data = data;
    }

    public BinSortTree getRchild() {
        return rchild;
    }

    public void setRchild(BinSortTree rchild) {
        this.rchild = rchild;
    }

    public BinSortTree getLchild() {
        return lchild;
    }

    public void setLchild(BinSortTree lchild) {
        this.lchild = lchild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
