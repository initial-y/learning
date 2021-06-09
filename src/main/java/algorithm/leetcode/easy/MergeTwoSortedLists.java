package algorithm.leetcode.easy;

/**
 * @className MergeTwoSortedLists
 * @description
 * @link https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 * @author initial_y
 * @date 2021/06/09
 */
public class MergeTwoSortedLists {

    /**
     * 尾插
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return  l1 == null ? l2 : l1;
        }
        ListNode node = null;
        if (l1.val <= l2.val) {
            node = l1;
            l1 = l1.next;
        } else {
            node = l2;
            l2 = l2.next;
        }

        // 尾插法
        ListNode tail = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 == null) {
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }

        return node;
    }

}
