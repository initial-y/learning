package algorithm.leetcode.medium;


import algorithm.leetcode.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @className: AddTwoNumbers2
 * @author: initial_yang
 * @date: 2020/4/21
 * @no 445
 * @see https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers2 {

    /**
     * 迭代 翻转链表方式
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
     * 迭代 翻转链表
     * @param head
     * @return
     */
    private ListNode reverseListNode(ListNode head) {
        ListNode cur = head;
        ListNode reverse = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = tmp;
        }
        return reverse;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = this.reverseIterator(l1);
        ListNode reverseL2 = this.reverseIterator(l2);

        ListNode sumNode = null;
        int carry = 0;
        while (reverseL1 != null && reverseL2 != null) {
            int sum = reverseL1.val + reverseL2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode cur = new ListNode(sum);
            cur.next = sumNode;
            sumNode = cur;

            reverseL1 = reverseL1.next;
            reverseL2 = reverseL2.next;
        }
        while (reverseL1 != null) {
            int sum = reverseL1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode cur = new ListNode(sum);
            cur.next = sumNode;
            sumNode = cur;

            reverseL1 = reverseL1.next;
        }
        while (reverseL2 != null) {
            int sum = reverseL2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode cur = new ListNode(sum);
            cur.next = sumNode;
            sumNode = cur;

            reverseL2 = reverseL2.next;
        }

        if (carry > 0) {
            ListNode cur = new ListNode(carry);
            cur.next = sumNode;
            sumNode = cur;
        }

        return sumNode;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    private ListNode reverseIterator(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseNode = reverseIterator(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }

    /**
     * 利用Stack
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = turnToStack(l1);
        Stack<Integer> s2 = turnToStack(l2);

        int carry = 0;
        ListNode sumNode = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = sumNode;
            sumNode = cur;
        }

        while (!s1.isEmpty()) {
            int sum = s1.pop() + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = sumNode;
            sumNode = cur;
        }

        while (!s2.isEmpty()) {
            int sum = s2.pop() + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = sumNode;
            sumNode = cur;
        }

        if (carry > 0) {
            ListNode cur = new ListNode(carry);
            cur.next = sumNode;
            sumNode = cur;
        }

        return sumNode;
    }

    private Stack turnToStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}
