package com.leetcode.demo.publicPojo;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Test1 test1 = new Test1();
      ListNode acc =  solution.addTwoNumbers(test1.a,test1.b);
      while (acc != null){
          System.out.println(acc.val);
          acc = acc.next;
      }
    }
}
