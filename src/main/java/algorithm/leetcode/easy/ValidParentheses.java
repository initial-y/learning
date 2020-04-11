package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @ClassName ValidParentheses
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/10
 * @no 20
 * @see https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }

        Stack<Character> stack = new Stack();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!stack.isEmpty()) {
                if (charArr[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                if (charArr[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                if (charArr[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                stack.push(charArr[i]);
            } else {
                stack.push(charArr[i]);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidTwo(String s) {
        if ("".equals(s)) {
            return true;
        }

        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左括号
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { // 右括号
                // 当前c是右括号 但是stack是空
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = (char) stack.peek();
                if (topChar == '(' && c == ')' || topChar == '[' && c == ']' || topChar == '{' && c == '}') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

}
