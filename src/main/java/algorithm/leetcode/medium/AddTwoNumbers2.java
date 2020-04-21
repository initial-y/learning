package algorithm.leetcode.medium;

import algorithm.leetcode.easy.ListNode;

import java.util.List;

/**
 * @className: AddTwoNumbers2
 * @author: initial_yang
 * @date: 2020/4/21
 * @no 445
 * @see https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers2 {

    /**
     * 翻转链表方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode node1 = reverseListNode(l1);
        ListNode node2 = reverseListNode(l2);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int num1 = (node1 == null) ? 0 : node1.val;
            int num2 = (node2 == null) ? 0 : node2.val;

            int sum = carry + num1 + num2;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return reverseListNode(dummyHead.next);
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverseListNode(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
