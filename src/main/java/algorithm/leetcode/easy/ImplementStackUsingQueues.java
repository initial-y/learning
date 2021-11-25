package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @className ImplementStackUsingQueues
 * @description 
 * @author initial.y
 * @date 2021/07/06
 * @num 225
 * @link https://leetcode-cn.com/problems/implement-stack-using-queues
 */
public class ImplementStackUsingQueues {

    private List<Integer> list;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        list = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int pop = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return pop;
    }

    /** Get the top element. */
    public int top() {
        return list.get(list.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
