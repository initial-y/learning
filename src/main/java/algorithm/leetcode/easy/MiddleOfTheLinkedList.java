package algorithm.leetcode.easy;

import algorithm.leetcode.ListNode;

/**
 * @author initial.y
 * @className MiddleOfTheLinkedList
 * @description
 * @date 2021/8/6
 * @num 876
 * link https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
