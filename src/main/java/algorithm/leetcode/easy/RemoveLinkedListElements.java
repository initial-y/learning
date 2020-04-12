package algorithm.leetcode.easy;

/**
 * @ClassName RemoveLinkedListElements
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 * @no 203
 * @see https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // head.val = val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        // head.val != val, 通过prev遍历
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val != val) {
                prev = prev.next;
            } else {
                prev.next = prev.next.next;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
