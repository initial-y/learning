package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @className NextGreaterElement2
 * @description 
 * @author xin.yang
 * @date 2021/07/09
 * @num 503
 * @link
 */
public class NextGreaterElement2 {

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % length]) {
                result[stack.pop()] = nums[i % length];
            }
            stack.push(i % length);
        }
        return result;
    }

    /**
     * 暴力循环
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        if (nums == null) {
            return null;
        }
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        // O(n^2)
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < 2 * length; j++) {
                if (nums[j % length] > cur) {
                    result[i] = nums[j % length];
                    break;
                }
            }
        }
        return result;
    }
}
