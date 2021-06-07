package algorithm.leetcode.easy;

/**
 * @ClassName IntersectionOfTwoLinkedLists
 * @Descripiton
 * @link https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * @Author initial_yang
 * @Date 2021/6/7
 */
public class IntersectionOfTwoLinkedLists {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
                // why equals
                if (nodeA.equals(nodeB)) {
                    return nodeA;
                }
            }
        }
        return null;
    }

}
