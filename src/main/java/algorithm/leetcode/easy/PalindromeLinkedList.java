package algorithm.leetcode.easy;

import java.util.Stack;
import algorithm.leetcode.ListNode;

/**
 * @ClassName PalindromeLinkedList
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/14
 * @no
 * @see https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            slow = fast.next;
            fast = fast.next.next;
        }

        // 偶数个ListNode
        if (fast == null) {

        } else {

        }

        return false;
    }

    /**
     * 反转整个链表
     * @param head
     * @return
     */
    public boolean isPalindromeWithReverseListNode(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode cur = head;
        ListNode reverseNode = new ListNode(cur.val);
        while (cur.next != null) {
            ListNode node = new ListNode(cur.next.val);
            node.next = reverseNode;
            reverseNode = node;
            cur = cur.next;
        }
        System.out.println(reverseNode.toString());

        while (head.next != null && reverseNode.next != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }

        // 一个数的情况
        return head.val == reverseNode.val;
    }


    public boolean isPalindrome2(ListNode head) {
        // todo 翻转链表会改变head的引用
        ListNode reverse = this.reverse(head);
        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverse = null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode cur = tmp.next;
            tmp.next = reverse;
            reverse = tmp;
            tmp = cur;
        }
        return reverse;
    }
}
