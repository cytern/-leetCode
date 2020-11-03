package com.leetcode.demo.test0207重复链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 设链表A的长度为a，链表B的长度为b，A到相交结点的距离为c,B到相交节点的距离为d，显然可以得到两者相交链表的长度：a - c = b - d， 变换一下式子得到:a + d = b + c
 * 我们用一个指针从链表A出发，到末尾后就从B出发，用另一个指针从B出发，到末尾后从A出发，由于上面的公式，当前一个指针走了a+d步数时，后一个指针走了b+c,两步数相等，即走到了相交节点。
 *
 * 作者：antione
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/solution/chao-jian-dan-zheng-ming-shuang-zhi-zhen-de-zheng-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode listNodeA = headA;
            ListNode listNodeB = headB;
            while (listNodeA!=listNodeB){
                listNodeA = listNodeA != null ?listNodeA.next:headB;
                listNodeB = listNodeB != null ?listNodeB.next :headA;
            }
            return listNodeB;

    }

}