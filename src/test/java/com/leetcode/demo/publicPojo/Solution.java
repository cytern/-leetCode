package com.leetcode.demo.publicPojo;

import java.math.BigDecimal;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           BigDecimal num1 = new BigDecimal(0);
        BigDecimal num2 = new BigDecimal(0);
           int a = 1;
           int b = 1;
       ListNode temp1 = l1;
       ListNode temp2 = l2;
           while (temp1 != null){
               num1 = num1.add(BigDecimal.valueOf(temp1.val*a));
               System.out.println(temp1.val*a + "    的1数值是");
               System.out.println(num1);
               a = a*10;
               temp1 = temp1.next;
           }
           while (temp2 != null){
               num2 = num2.add(BigDecimal.valueOf(temp2.val*b));
               System.out.println(temp2.val*b + "  的2数值是");
               System.out.println(num2);
               b  = b*10;
               temp2 = temp2.next;
           }
           BigDecimal totalNum =num1.add(num2);
        System.out.println(totalNum);
         ListNode backListNode =null;
        ListNode temList = null;
           while (totalNum.compareTo(BigDecimal.valueOf(10)) >= 0){
             BigDecimal val[] = totalNum.divideAndRemainder(BigDecimal.valueOf(10));

             totalNum =totalNum.subtract(val[1]);
             totalNum =totalNum.divide(BigDecimal.valueOf(10));
       ListNode listNode = new ListNode(val[1].intValue());
             if (backListNode == null){
                 temList = listNode;
                 backListNode = temList;
             }else {
                 temList.next = listNode;
                 temList =temList.next;
             }
           }
           ListNode acc = new ListNode(totalNum.intValue());
        if(temList == null){

            return new ListNode(totalNum.intValue());
        }
           temList.next = acc;
           temList = temList.next;

           return  backListNode;

    }
}
