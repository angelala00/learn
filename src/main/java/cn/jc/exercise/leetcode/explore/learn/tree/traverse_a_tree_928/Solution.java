package cn.jc.exercise.leetcode.explore.learn.tree.traverse_a_tree_928;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        addNode(list, root);
        return list;
    }

    private void addNode(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            addNode(list, root.left);
            addNode(list, root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
