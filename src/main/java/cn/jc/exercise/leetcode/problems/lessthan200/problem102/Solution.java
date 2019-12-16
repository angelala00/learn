package cn.jc.exercise.leetcode.problems.lessthan200.problem102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        int countCrrentLayer = 0;
        int countNextLayer = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        countCrrentLayer++;

        TreeNode node;
        while ((node = queue.poll()) != null) {
            System.out.println(node.val);
            countCrrentLayer--;
            queue.offer(node.left);
            countNextLayer++;
            queue.offer(node.right);
            countNextLayer++;
        }

        return null;
    }
}
