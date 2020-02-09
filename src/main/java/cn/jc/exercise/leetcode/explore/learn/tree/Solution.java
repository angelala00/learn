package cn.jc.exercise.leetcode.explore.learn.tree;

class Solution {
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode buildTree(int inorder_start, int inorder_end, int postorder_start, int postorder_end) {
        System.out.println("inorder_start = " + inorder_start + ", inorder_end = " + inorder_end + ", postorder_start = " + postorder_start + ", postorder_end = " + postorder_end);
        TreeNode root = new TreeNode(postorder[postorder_end]);
        if (inorder_end - inorder_start > 0) {
            int inorder_idx = findIdx(inorder, root.val);
            System.out.println("val = " + root.val + " inorder_idx = " + inorder_idx);
            root.left = buildTree(0, inorder_idx - 1, 0, inorder_idx - 1);
            root.right = buildTree(inorder_idx + 1, inorder.length - 1, inorder_idx, postorder.length - 2);
        }
        return root;
    }
    public int findIdx(int[] arr, int val) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a;
        int[] arr1 = new int[]{9,3,15,20,7};
        int[] arr2 = new int[]{9,15,7,20,3};
        new Solution().buildTree(arr1,arr2);
    }
}
