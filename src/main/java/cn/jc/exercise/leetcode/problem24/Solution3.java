package cn.jc.exercise.leetcode.problem24;

class Solution3 {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode a = preHead;
        while (a.next != null && a.next.next != null) {
            ListNode b, c;
            b = a.next;
            c = b.next;

            b.next = c.next;
            a.next = c;
            c.next = b;

            a = b;
        }
        return preHead.next;
    }
}