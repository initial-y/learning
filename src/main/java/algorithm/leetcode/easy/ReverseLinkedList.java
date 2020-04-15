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
     * 反转链表：空间复杂度O(n)
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

}
