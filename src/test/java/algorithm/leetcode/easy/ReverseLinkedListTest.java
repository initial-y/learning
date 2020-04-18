package algorithm.leetcode.easy;

import org.junit.Test;

/**
 * @ClassName ReverseLinkedListTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/16
 */
public class ReverseLinkedListTest {

    @Test
    public void test_recursion() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        ListNode reverseNode = new ReverseLinkedList().reverseListWithRecursion(head);
        System.out.println(reverseNode.toString());
    }

}
