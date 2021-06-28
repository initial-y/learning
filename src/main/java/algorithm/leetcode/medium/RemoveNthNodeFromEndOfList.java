package algorithm.leetcode.medium;

import algorithm.leetcode.ListNode;

/**
 * @ClassName RemoveNthNodeFromEndOfList
 * @Descripiton
 * @Author initial_yang
 * @link https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * @Date 2021/6/14
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 倒数第n = 正数length-n+1
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }

        int rmNum = length - n + 1;
        // why not 0 : 最后一次满足cur.next != null && num != rmNum之后, cur=cur.next, 刚好是需要移除的节点的前一个节点
        int num = 1;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && num != rmNum) {
            cur = cur.next;
            num++;
        }
        if (cur.next != null && cur.next.next != null) {
            cur.next = cur.next.next;
        } else {
            cur.next = null;
        }

        return dummy.next;
    }

    /**
     * todo 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndWithFastSlow(ListNode head, int n) {

        return null;
    }
}
