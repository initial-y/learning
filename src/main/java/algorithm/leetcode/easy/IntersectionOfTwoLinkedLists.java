package algorithm.leetcode.easy;

import algorithm.leetcode.ListNode;
/**
 * @ClassName IntersectionOfTwoLinkedLists
 * @Descripiton
 * @link https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * @Author initial_yang
 * @Date 2021/6/7
 */
public class IntersectionOfTwoLinkedLists {


    /**
     * 暴力穷举 O(m*n)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNodeRough(ListNode headA, ListNode headB) {
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
                // why equals : object.equals 比较地址, 地址相等链表才算相同, 值相等不算
                if (nodeA.equals(nodeB)) {
                    return nodeA;
                }
            }
        }
        return null;
    }


    /**
     * 链表互补
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return nodeA;
    }



    public static void main(String[] args) {
        ListNode headA = new ListNode(new int[]{2,6,4});
        ListNode headB = new ListNode(new int[]{1,5});
//        headB.next = headA.next.next;
        System.out.println(headB);
        System.out.println(getIntersectionNode(headA, headB));
    }

}
