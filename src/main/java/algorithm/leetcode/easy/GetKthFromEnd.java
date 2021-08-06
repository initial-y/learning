package algorithm.leetcode.easy;

import algorithm.leetcode.ListNode;

/**
 * @author initial.y
 * @className GetKthFromEnd
 * @description
 * @date 2021/8/6
 * @num 剑指22
 * @link https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class GetKthFromEnd {
    /**
     * 倒数第k = 正数length-k
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length ++;
        }
        System.out.println(length);
        int n = length - k;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;

    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {

        ListNode fast = head, slow = head;
        // 快指针先走k
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 此时快慢指针一起走知道快指针为空
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
