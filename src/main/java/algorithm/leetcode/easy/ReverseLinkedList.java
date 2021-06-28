package algorithm.leetcode.easy;
import algorithm.leetcode.ListNode;
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
     * reverseList()进阶： 时间复杂度O(n), 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode reverseListPro(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    /**
     * 通过递归反转链表： 时间复杂度O(n), 空间复杂度O(n)
     * @desc  递归三要素：问题分解、递推公式、终止条件
     * @param head
     * @return
     */
    public ListNode reverseListWithRecursion(ListNode head) {
        // 假设head = 1 - 2 - 3 - 4 - 5 - null
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归条件
        System.out.println("head: " + head.toString());
        System.out.println("head.next: " + head.next.toString());
        // 关键要理解p和反转指针head的关系
        // last始终是最后以一个节点开始的节点，后续的操作就是将值添加到last的末尾 从5-null 到 5-4-null 一直到5-4-3-2-1-null
        ListNode last = reverseListWithRecursion(head.next);
        // 反转指针
        System.out.println("before reverse, last:" + last.toString());
        // 此时对于head来说只是将head移到head.next后面去，但是对last来说其实是将head的值添加到last的末尾
        head.next.next = head;
        head.next = null;
        System.out.println("after reverse, last:" + last.toString());
        return last;
    }
}
