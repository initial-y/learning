package algorithm.leetcode.easy;
import algorithm.leetcode.ListNode;
/**
 * @className RemoveDuplicatesFromSortedList
 * @description
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 * @author initial_y
 * @date 2021/06/11
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
