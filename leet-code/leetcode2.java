import java.awt.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";

        while (null != l1) {
            s1 = l1.val + s1;
            l1 = l1.next;
        }

        while (null != l2) {
            s2 = l2.val + s2;
            l2 = l2.next;
        }

        String sum = new BigInteger(s1).add(new BigInteger(s2)).toString();
        char[] sumchar = sum.toCharArray();
        ListNode res = new ListNode(0);
        for (char cnum : sumchar) {
            ListNode newNode = new ListNode(Integer.valueOf(String.valueOf(cnum)));
            newNode.next = res.next;
            res.next = newNode;
        }
        return res.next;
    }

}