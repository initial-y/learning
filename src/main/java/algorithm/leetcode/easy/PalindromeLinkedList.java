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

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        // 构造函数
        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("empty arr");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val + "->");
                cur = cur.next;
            }
            sb.append("Null");
            return sb.toString();
        }
    }
}
