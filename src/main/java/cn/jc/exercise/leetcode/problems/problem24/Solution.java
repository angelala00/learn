package cn.jc.exercise.leetcode.problems.problem24;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode a, b, c, d;
        b = head;
        c = b.next;
        d = c.next;
        b.next = d;
        c.next = b;
        head = c;
        while (b != null && b.next != null && b.next.next != null) {
            a = b;
            b = a.next;
            c = b.next;
            d = c.next;

            a.next = c;
            b.next = d;
            c.next = b;
        }
        return head;
    }
}
