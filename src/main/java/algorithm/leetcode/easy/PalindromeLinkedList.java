package algorithm.leetcode.easy;

import algorithm.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PalindromeLinkedList
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/14
 * @no 234
 * @see https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * @see https://leetcode-cn.com/problems/palindrome-linked-list/
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
        ListNode reverse = this.reverse2(head);
        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    /**
     *  翻转链表会改变head的引用
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode cur = head.next;
            head.next = reverse;
            reverse = head;
            head = cur;
        }
        return reverse;
    }

    /**
     * 不改变head的引用
     * @param head
     * @return
     */
    private ListNode reverse2(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = reverse;
            reverse = cur;
            head = head.next;
        }
        return reverse;
    }

    /**
     * 链表转List
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        List<Integer> list = this.turnToList(head);

        int start = 0, end = list.size() - 1;
        // 需限制start <= end
        while (start != end && start <= end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private List<Integer> turnToList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
