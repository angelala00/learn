package cn.jc.exercise.leetcode.problems.lessthan100.problem24;

class Solution4 {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode a = preHead;
        while (a.next != null && a.next.next != null) {
            ListNode b = a.next;

            a.next = b.next;
            b.next = a.next.next;
            a.next.next = b;

            a = b;
        }
        return preHead.next;
    }
}
