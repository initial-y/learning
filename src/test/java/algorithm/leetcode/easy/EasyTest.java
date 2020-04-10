package algorithm.leetcode.easy;

import org.junit.Test;

import java.util.Stack;

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
    public void test_stack() {
        Stack stack = new Stack();
        System.out.println(stack.peek());
    }

}
