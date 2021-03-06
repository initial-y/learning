package algorithm.leetcode.easy;

import algorithm.leetcode.ListNode;

/**
 * @ClassName RemoveLinkedListElements
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 * @no 203
 * @see https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    /**
     * 比较 & 删除， 需处理头结点
     * @param head
     * @param val
     * @return
     */
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

    /**
     * 通过虚拟头结点删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsWithDummyHead(ListNode head, int val) {
        // 按理应该赋值null, 这里题设指定了数据接口
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        head = dummyHead;

        // 设置了虚拟头结点 从head.next开始遍历
        while (head.next != null ) {
            if (head.next.val == val) {
                // 值匹配则跳过
                head.next = head.next.next;
            } else {
                // 值不匹配修改head(等价于修改removeElements的prev)
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 利用递归解决
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsWithRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
//        ListNode res = removeElementsWithRecursion(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElementsWithRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }



}
