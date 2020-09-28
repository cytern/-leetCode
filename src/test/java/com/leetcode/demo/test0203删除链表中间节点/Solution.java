package com.leetcode.demo.test0203删除链表中间节点;



public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
