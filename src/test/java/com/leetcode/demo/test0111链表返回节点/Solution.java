package com.leetcode.demo.test0111链表返回节点;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     *
     * @param head
     * @param k
     * @return
     *
     * 遍历第一次差值来获得最大遍历
     */
    public static int backVal(ListNode head,int k){
    ListNode p = head;
    for(int i=0;i<k;i++){
        p = p.next;
    }

    while(p != null){
        p = p.next;
        head = head.next;
    }

    return head.val;


}
}

