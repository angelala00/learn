package cn.jc.exercise.leetcode.problems.lessthan500.problem449;

class Codec {

//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "n";
//        }
//        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
//    }
//
//    public TreeNode deserialize(String data) {
//        String[] ds = data.split(",");
//        TreeNode root = null;
//        build(root,ds,0);
////        for (int i = 0; i < ds.length; i++) {
////            if (root == null) {
////                root = new TreeNode(Integer.parseInt(ds[0]));
////            }
////        }
//        return root;
//    }
//
//    private void build(String[] ds, int i) {
//        if ("n".equals(ds[i])) {
//
//        } else {
//            TreeNode root = new TreeNode(Integer.parseInt(ds[0]));
//            root.left = build(ds, i + 1);
//            root.right = build(ds, i + 1);
//
//        }
//    }
//
//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(4);
//        node.left = new TreeNode(5);
//        node.left.left = new TreeNode(3);
//        node.right = new TreeNode(6);
//        node.right.right = new TreeNode(9);
//        node.right.right.left = new TreeNode(2);
//        System.out.println(new Codec().serialize(node));
//    }
}
