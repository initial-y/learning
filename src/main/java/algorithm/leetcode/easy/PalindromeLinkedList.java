package algorithm.leetcode.easy;

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

}
