package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @className MinStack
 * @description 
 * @author initial.y
 * @date 2021/07/06
 * @num 155
 * @link https://leetcode-cn.com/problems/min-stack/description/
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
       stack = new Stack<>();
       min = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min.push(val);
        } else {
            // <=: 为了处理最小值重复push的情况 push: 0,1,0
            if (val <= min.peek()) {
                min.push(val);
            }
        }
        stack.push(val);
    }

    public void pop() {
        // 考虑最小值出栈的场景
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
