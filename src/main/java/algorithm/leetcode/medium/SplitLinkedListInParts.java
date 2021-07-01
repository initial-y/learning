package algorithm.leetcode.medium;

import algorithm.leetcode.ListNode;

/**
 * @author xin.yang2@dmall.com
 * @className SplitLinkedListInParts
 * @description
 * @date 2021/07/01
 * @no 725
 * @link https://leetcode-cn.com/problems/split-linked-list-in-parts/description/
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = this.getListNodeLength(head);
        ListNode[] array = new ListNode[k];
        int nodeLength = length / k;
        int extraLength = length % k;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode node = cur;
            if (cur != null) {
                if (extraLength > 0) {
                    // nodeLength
                    for (int j = 0; j < nodeLength; j++) {
                        cur = cur.next;
                    }
                    ListNode next = cur.next;
                    cur.next = null;
                    array[i] = node;
                    cur = next;
                    extraLength--;
                } else {
                    // nodeLength - 1
                    for (int j = 0; j < nodeLength - 1; j++) {
                        cur = cur.next;
                    }
                    ListNode next = cur.next;
                    cur.next = null;
                    array[i] = node;
                    cur = next;
                }
            } else {
                array[i] = null;
            }
        }

        return array;
    }

    private int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
