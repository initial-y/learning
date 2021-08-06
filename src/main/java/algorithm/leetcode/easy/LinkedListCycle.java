package algorithm.leetcode.easy;

import algorithm.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author initial.y
 * @className LinkedListCycle
 * @description
 * @date 2021/8/6
 * @num 141
 * @link https://leetcode-cn.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }


    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            // add存在于set里的值, 返回false
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
