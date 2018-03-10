package cn.jc.datastructure.tree;
public class BinTree {
    private String data;
    private BinTree rchild;
    private BinTree lchild;

    public BinTree(String data) {
        this.data = data;
    }

    public BinTree getRchild() {
        return rchild;
    }

    public void setRchild(BinTree rchild) {
        this.rchild = rchild;
    }

    public BinTree getLchild() {
        return lchild;
    }

    public void setLchild(BinTree lchild) {
        this.lchild = lchild;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
