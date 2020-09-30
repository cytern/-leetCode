package com.leetcode.demo.test0205链表求和;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           int num1 = 0;
           int num2 = 0;
           int a = 1;
           int b = 2;
           ListNode temp1 = l1;
           ListNode temp2 = l2;
           while (temp1.next != null){
               num1 = num1 + temp1.val*a;
               a = a*10;
               temp1 = temp1.next;
           }
           while (temp2.next != null){
               num2 = num2 + temp2.val * b;
               b  = b*10;
               temp2 = temp2.next;
           }
           int totalNum = num1 + num2;
           int c = 1;
           ListNode backListNode =null;
           ListNode temList = null;
           while (totalNum >10){
             int val = totalNum%10;
             totalNum =totalNum -val;
             totalNum =totalNum /10;
             ListNode listNode = new ListNode(val);
             if (backListNode == null){
                 temList = listNode;
                 backListNode = temList;
             }else {
                 temList.next = listNode;
                 temList =temList;
             }
           }
           return  backListNode;

    }
}
