package algorithm.algo4.charpter1;

import java.util.Stack;

/**
 * @className Parentheses
 * @description 1.3.4
 * @date 2021/05/19
 */
public class Parentheses {


    public boolean isParentheses(String inputStr) {
        Stack<String> stack = new Stack();
        String[] arr = inputStr.split("");
        for (int i = 0; i < arr.length; i++) {
            String currentStr = arr[i];
            if (!stack.isEmpty()) {
                String peekStr = stack.peek();
                boolean isEqualParentheses = this.isEqualParentheses(peekStr, currentStr);
                if (isEqualParentheses) {
                    stack.pop();
                } else {
                    stack.push(currentStr);
                }
            } else {
                stack.add(currentStr);
            }
        }
        return stack.isEmpty();
    }

    private boolean isEqualParentheses(String source, String target) {
        switch (source) {
            case "{" :
                return "}".equals(target);
            case "(":
                return ")".equals(target);
            case "[":
                return "]".equals(target);
            default:
                return false;
        }
    }


}
