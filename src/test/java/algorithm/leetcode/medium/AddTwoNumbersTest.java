package algorithm.leetcode.medium;

import algorithm.leetcode.easy.ListNode;
import org.junit.Test;

/**
 * @ClassName AddTwoNumbersTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/21
 */
public class AddTwoNumbersTest {

    @Test
    public void test_add_two_numbers() {
        int[] arr1 = {1, 2, 3};
        ListNode node1 = new ListNode(arr1);

        int[] arr2 = {1, 2, 3};
        ListNode node2 = new ListNode(arr2);

        ListNode sumNode = new AddTwoNumbers().addTwoNumbers(node1, node2);
        System.out.println(sumNode);
    }
}
