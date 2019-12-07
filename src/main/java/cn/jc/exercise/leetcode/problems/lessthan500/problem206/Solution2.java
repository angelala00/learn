package cn.jc.exercise.leetcode.problems.lessthan500.problem206;

public class Solution2 {
    public ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode tmp = null;
        while (current.next != null) {
            tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        current.next = pre;
        return current;
    }
}
