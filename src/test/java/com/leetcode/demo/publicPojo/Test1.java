package com.leetcode.demo.publicPojo;

public class Test1 {
    ListNode a = new ListNode(2);
    ListNode b = new ListNode(4);
    ListNode a2 = new ListNode(5);
    ListNode a3 = new ListNode(2);
    ListNode b2 = new ListNode(4);
    ListNode b3 = new ListNode(7);
    public Test1(){
        a.next = a2;
a2.next = a3;
        b.next = b2;
       b2.next = b3;
    }
}
