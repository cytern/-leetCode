package com.leetcode.demo.test0204删除链表中间的节点;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        ListNode curNode = head;
        while(curNode.next != null){
            if(curNode.next.val < x){
                ListNode tmp = curNode.next;
                curNode.next = curNode.next.next;
                tmp.next = head;
                head = tmp;
            }
            else
                curNode = curNode.next;
        }

        return head;
    }
}
