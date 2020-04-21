package algorithm.leetcode.medium;

import algorithm.leetcode.easy.ListNode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

/**
 * @ClassName AddTwoNumbersTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/21
 */
public class AddTwoNumbersTest {

    @Test
    public void test_add_two_numbers_wrong() {
        int[] arr1 = {1, 2, 3};
        ListNode node1 = new ListNode(arr1);

        int[] arr2 = {1, 2, 3};
        ListNode node2 = new ListNode(arr2);

        ListNode sumNode = new AddTwoNumbers().addTwoNumbersWrong(node1, node2);
        System.out.println(sumNode);
    }

    @Test
    public void test_add_two_numbers() {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode node1 = new ListNode(arr1);

        int[] arr2 = {1, 2, 3};
        ListNode node2 = new ListNode(arr2);

        ListNode sumNode = new AddTwoNumbers().addTwoNumbers(node1, node2);
        System.out.println(sumNode);

        int[] resultArr = {2, 4, 6, 4, 5};
        ListNode resultNode = new ListNode(resultArr);
//        assertThat(sumNode, is(resultNode));
    }
}
