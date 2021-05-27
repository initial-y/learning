package algorithm.algo4.charpter1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @className Parentheses
 * @description 1.3.4
 * @date 2021/05/19
 */
public class Parentheses {


    /**
     * 是否合法的括号对
     * @param inputStr
     * @return
     */
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


    /**
     * 补齐左括号
     * @param inputStr
     * @return
     */
    public String addLeftParentheses(String inputStr) {
        Stack<String > operatorStack = new Stack();
        Stack<String > resultStack = new Stack();

        List<String> operatorList = Arrays.asList("+", "-", "*", "/");
        String[] arr = inputStr.split("");
        for (String str : arr) {
            if (operatorList.contains(str)) {
                operatorStack.push(str);
            } else if (!")".equals(str)) {
                resultStack.push(str);
            } else {
                String num1 = resultStack.pop();
                String num2 = resultStack.pop();
                String operator = operatorStack.pop();
                String tmpResultStr = "(" + num2 + operator + num1 + str;
                resultStack.push(tmpResultStr);
            }
        }

        String result = resultStack.pop();
        while (!resultStack.isEmpty()) {
            result = resultStack.pop() + operatorStack.pop() + result;
        }

        return result;
    }


}
