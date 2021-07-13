package algorithm.leetcode.medium;

import algorithm.leetcode.ListNode;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @className: MediumTest
 * @author: yangxin
 * @date: 2020/4/9
 */
public class MediumTest {

    private static final Gson gson = new Gson();

    @Test
    public void test_RemoveDuplicates2_removeDuplicates() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int length = new RemoveDuplicates2().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        assertEquals(length, 5);
        assertEquals(nums[0], 1);
        assertEquals(nums[2], 2);
    }

    @Test
    public void test_GenerateParentheses_generateParenthesis() {
        List<String> parenthesis = new GenerateParentheses().generateParenthesis(3);
        System.out.println(gson.toJson(parenthesis));
        assertEquals(parenthesis.size(), 5);
    }

    @Test
    public void test_SortColors_sortColors() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        System.out.println(gson.toJson(nums));
        assertEquals(nums[0], 0);
    }

    @Test
    public void test_KthLargestElement_findKthLargest() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        assertEquals(new KthLargestElement().findKthLargest(nums, 2), 5);
    }


    @Test
    public void test_removeNthFromEnd() {
        int[] nums = {1};
//        ListNode node = new RemoveNthNodeFromEndOfList().removeNthFromEnd(new ListNode(nums), 2);
//        System.out.println(node.toString());
    }

    @Test
    public void testAddTwoNumbers2() {
        ListNode l1 = new ListNode(new int[] {7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[] {5, 6, 4});
        ListNode sumNode = new AddTwoNumbers2().addTwoNumbers(l1, l2);
        System.out.println(sumNode.toString());
    }

    @Test
    public void test_splitListToParts() {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9 , 10});
        ListNode[] arr = new SplitLinkedListInParts().splitListToParts(head, 3);
        System.out.println(new Gson().toJson(arr));
    }

    @Test
    public void test_nextGreaterElements() {
        int[] arr = new int[] {1,2,3,4,3};
        int[] result = new NextGreaterElement2().nextGreaterElements2(arr);
        System.out.println(gson.toJson(result));
    }

    @Test
    public void test_dailyTemperatures() {
        int[] arr = new int[]{30,40,50,60};
        int[] result = new DailyTemperatures().dailyTemperatures1(arr);
        System.out.println(gson.toJson(result));
    }
}
