package com.leetcode.demo.test0205链表求和;

public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode sumList = new ListNode(0);
        ListNode tail = sumList;

        while(l1 != null || l2 != null){
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);

            add = s / 10;
            tail.next = new ListNode(s % 10);
            tail = tail.next;
        }
        if(add != 0)
            tail.next = new ListNode(add);
        return sumList.next;
    }
}
