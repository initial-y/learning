package algorithm.leetcode.easy;
import algorithm.leetcode.ListNode;
/**
 * @author initial_y
 * @className RemoveDuplicatesFromSortedList
 * @description
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @date 2021/06/11
 */
public class RemoveDuplicatesFromSortedList2 {


    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 需要特殊处理头结点的情况, 优先考虑新增虚拟头结点
        ListNode dummy = new ListNode(-1, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int repeatNum = cur.next.val;
                while (cur.next != null && cur.next.val == repeatNum) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    /**
     * todo
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tail = dummy;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            } else {
                tail.next = cur;
                tail = cur;
            }

            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * todo 递归
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesRecursive(ListNode head) {

        return head;
    }
}
