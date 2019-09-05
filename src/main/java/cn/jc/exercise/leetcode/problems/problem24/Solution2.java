package cn.jc.exercise.leetcode.problems.problem24;

class Solution2 {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode a = preHead;

        while (a.next != null && a.next.next != null) {
            ListNode b, c, d;
            b = a.next;
            c = b.next;
            d = c.next;

            a.next = c;
            c.next = b;
            b.next = d;

            a = b;
        }
        return preHead.next;
    }
}
