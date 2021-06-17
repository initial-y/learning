package algorithm.leetcode.medium;

import algorithm.leetcode.ListNode;

/**
 * @className SwapNodesInPairs
 * @description 
 * @author initial_y
 * @link https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @date 2021/06/16
 */
public class SwapNodesInPairs {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 本级递归
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        // 返回值
        return next;
    }

    /**
     * 迭代
     */
    public ListNode swapPairsIterator(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            // 两两交换, 注意使用临时变量暂存值
            ListNode next1 = tmp.next;
            ListNode next2 = tmp.next.next;
            tmp.next = next2;
            next1.next = next2.next;
            tmp.next.next = next1;

            // 刷新tmp
            tmp = tmp.next.next;
        }

        return dummy.next;
    }
}
