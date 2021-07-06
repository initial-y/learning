package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @className MinStack
 * @description 
 * @author xin.yang
 * @date 2021/07/06
 * @num 155
 * @link https://leetcode-cn.com/problems/min-stack/description/
 */
public class MinStack {
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
       stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        } else {
            if (val < min) {
                min = val;
            }
        }
        stack.push(val);
    }

    public void pop() {
        // todo 最小值pop了怎么办?
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
