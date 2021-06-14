package algorithm.leetcode.easy;

/**
 * @className RemoveDuplicatesFromSortedList
 * @description 
 * @author initial_y
 * @date 2021/06/11
 */
public class RemoveDuplicatesFromSortedList2 {

    // todo
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode tail = head;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                tail = cur;
                cur = cur.next;
            } else {
                cur = cur.next;
            }

        }
        return head;
    }
}
