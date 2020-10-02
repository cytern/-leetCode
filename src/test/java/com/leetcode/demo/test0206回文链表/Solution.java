package com.leetcode.demo.test0206回文链表;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        //1.计算链表长度
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        //因为翻转链表时需要3个引用，所以对长度小于3的做特殊化处理。
        if (length == 1) return true;
        if (length == 2) return head.val == head.next.val;

        //2.翻转前半部分链表。
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        pre.next = null;

        //翻转链表实际上就是把currrent节点里的next引用指向pre指向的那个节点。。
        //翻转当前节点完毕后，把pre引用指向current,把current引用指向next，把next引用指向next.next，这样就可以继续翻转下一个节点了。
        for (int i = 1; i < length / 2; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        //翻转完毕后，如果链表长度为偶数，pre正好指向前半个链表的表头，cur正好指向后半个链表的表头
        //如果链表长度为奇数，pre指向前半个链表的表头，next指向后半个链表的表头，cur指向最中间的节点。
        //所以把cur指向next的那个节点，奇偶两种情况就可以共用下面的while循环了。
        if (length % 2 != 0) cur = next;
        while (pre != null && cur != null) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;

    }
}
