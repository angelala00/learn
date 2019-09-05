package cn.jc.exercise.leetcode.explore.learn.tree.traverse_a_tree_931;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        int lastLayer = 1;
        int currentLayer = 0;

        while (lastLayer != 0 || currentLayer != 0) {
            List<Integer> layerList = new ArrayList<>();
            list.add(layerList);
            for (int i = lastLayer; i >= 1; i--) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                layerList.add(node.val);
                System.out.println("node.val=" + node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    currentLayer++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    currentLayer++;
                }
            }
            lastLayer = currentLayer;
            currentLayer = 0;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode tree03 = new TreeNode(3);
        TreeNode tree09 = new TreeNode(9);
        TreeNode tree20 = new TreeNode(20);
        TreeNode tree15 = new TreeNode(15);
        TreeNode tree07 = new TreeNode(7);
        tree03.left = tree09;
        tree03.right = tree20;
        tree20.left = tree15;
        tree20.right = tree07;
        List<List<Integer>> r = new Solution().levelOrder(tree03);
        System.out.println("r="+r);
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
