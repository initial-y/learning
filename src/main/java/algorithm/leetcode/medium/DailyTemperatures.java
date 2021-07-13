package algorithm.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @className DailyTemperatures
 * @description 
 * @author xin.yang
 * @date 2021/07/08
 * @num 739
 * @link https://leetcode-cn.com/problems/daily-temperatures
 */
public class DailyTemperatures {
    /**
     * 暴力循环
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] resultArr = new int[temperatures.length];
        // 时间复杂度O(n^2)
        for (int i = 0; i < temperatures.length; i++) {
            resultArr[i] = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    resultArr[i] = j - i;
                    break;
                }
            }
        }
        return resultArr;
    }

    /**
     * 单调栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() &&  temperatures[i] > temperatures[deque.peek()]) {
                int top = deque.pop();
                result[top] = i - top;
            }
            deque.push(i);
        }
        return result;
    }
}
