package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @className ImplementQueueUsingStacks
 * @description 
 * @author initial.y
 * @date 2021/07/05
 * @num 232
 * @link https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> in;

    private Stack<Integer> out;



    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        in = new Stack<>();;
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        out.push(x);
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return in.pop();
    }

    /** Get the front element. */
    public int peek() {
        return in.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty();
    }

}
