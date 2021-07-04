package algorithm.leetcode.medium;

import algorithm.leetcode.ListNode;

/**
 * @className OddEvenLinkedList
 * @description 
 * @author
 * @date 2021/07/02
 * @num 328
 * @link https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        // 奇数链表在前, 要求奇数链表的最后一个节点不能为空, 因为odd.next = even.next, 所以要求even!=null
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
