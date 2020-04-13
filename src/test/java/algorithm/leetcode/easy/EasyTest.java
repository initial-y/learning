package algorithm.leetcode.easy;

import org.junit.Test;

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
        RemoveLinkedListElements rm = new RemoveLinkedListElements();
        RemoveLinkedListElements.ListNode listNode = rm.new ListNode(1);
        listNode.next = rm.new ListNode(2);
        RemoveLinkedListElements.ListNode head = rm.removeElements(listNode, 1);
        System.out.println(head != null ? head.val : null);
    }

    @Test
    public void test_RemoveLinkedListElements_removeElementsWithDummyHead() {
        RemoveLinkedListElements rm = new RemoveLinkedListElements();
        RemoveLinkedListElements.ListNode listNode = rm.new ListNode(1);
        listNode.next = rm.new ListNode(2);
        RemoveLinkedListElements.ListNode head = rm.removeElementsWithDummyHead(listNode, 2);
        System.out.println(head != null ? head.val : null);
    }

}
