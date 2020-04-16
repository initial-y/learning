package algorithm.leetcode.easy;

/**
 * @ClassName ReverseLinkedList
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/15
 * @no 206
 * @see https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     * 反转链表：空间复杂度O(n), 时间复杂度O(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode reverseNode = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = reverseNode;
            reverseNode = node;
            head = head.next;
        }
        return reverseNode;
    }

    /**
     * 通过递归反转链表： 时间复杂度O(n), 空间复杂度O(n)
     * @desc  todo
     * @param head
     * @return
     */
    public ListNode reverseListWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
