package algorithm.leetcode.easy;

import org.junit.Test;
import algorithm.leetcode.ListNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @className: EasyTest
 * @author: yangxin
 * @date: 2020/4/9
 */
public class EasyTest {

    @Test
    public void test_ValidParentheses_isValid() {
        assertTrue(new ValidParentheses().isValid("()"));
        assertTrue(new ValidParentheses().isValid("()[]{}"));
        assertFalse(new ValidParentheses().isValid("(]"));
        assertFalse(new ValidParentheses().isValid("([)]"));
    }

    @Test
    public void test_ValidParentheses_isValidTwo() {
        assertTrue(new ValidParentheses().isValidTwo("()"));
        assertTrue(new ValidParentheses().isValidTwo("()[]{}"));
        assertFalse(new ValidParentheses().isValidTwo("(]"));
        assertFalse(new ValidParentheses().isValidTwo("([)]"));
    }

    @Test
    public void test_RemoveLinkedListElements_removeElements() {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        RemoveLinkedListElements rm = new RemoveLinkedListElements();
        ListNode listNode = new ListNode(arr);
        ListNode node = rm.removeElements(listNode, 6);
        System.out.println(node.toString());
    }

    @Test
    public void test_RemoveLinkedListElements_removeElementsWithDummyHead() {
        RemoveLinkedListElements rm = new RemoveLinkedListElements();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode head = rm.removeElementsWithDummyHead(listNode, 2);
        System.out.println(head != null ? head.val : null);
    }

    @Test
    public void test_RemoveLinkedListElements_removeElementsWithRecursion() {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        RemoveLinkedListElements rm = new RemoveLinkedListElements();
        ListNode listNode = new ListNode(arr);
        ListNode node = rm.removeElementsWithRecursion(listNode, 6);
        System.out.println(node.toString());
    }


    @Test
    public void test_PalindromeLinkedList_isPalindromeWithReverseListNode() {
        PalindromeLinkedList palindrome = new PalindromeLinkedList();
        int[] arr1 = {1, 0, 3, 4, 0, 1};
        ListNode listNode1 = new ListNode(arr1);
        assertFalse(palindrome.isPalindromeWithReverseListNode(listNode1));

        int[] arr2 = {1, 2, 2, 1};
        ListNode listNode2 = new ListNode(arr2);
        assertTrue(palindrome.isPalindromeWithReverseListNode(listNode2));

        int[] arr3 = {1, 2, 3, 2, 1};
        ListNode listNode3 = new ListNode(arr3);
        assertTrue(palindrome.isPalindromeWithReverseListNode(listNode3));
    }

    @Test
    public void test_isPalindrome() {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode l1 = new ListNode(new int[] {1, 2, 3, 4});
        boolean flag = palindromeLinkedList.isPalindrome2(l1);
        assertFalse(flag);
    }

    @Test
    public void test_ReverseLinkedList_reverseList() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(new ReverseLinkedList().reverseList(head));
    }

    @Test
    public void test_ListNode() {
        ListNode node = new ListNode(new int[] {1,2,3,4});
//        this.iterator(node);
        while (node != null) {
            node = node.next;
        }
        System.out.println(node);
    }

    private void iterator(ListNode node) {
        ListNode cur = node;
        while (node != null) {
            node = node.next;
        }
    }

    @Test
    public void test_LongestHarmoniousSubsequence() {
        int[] arr = new int[]{1,4,1,3,1,-14,1,-13};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(arr));
    }
}
