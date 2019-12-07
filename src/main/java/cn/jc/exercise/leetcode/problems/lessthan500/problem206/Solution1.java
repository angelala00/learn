package cn.jc.exercise.leetcode.problems.lessthan500.problem206;

class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode target = null;
        while (head.next != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = target;
            target = tmp;
        }
        head.next = target;
        return head;
    }
}
