package algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * @className LongestHarmoniousSubsequence
 * @description 
 * @author initial.y
 * @date 2021/07/16
 * @num 594
 * @link https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 */
public class LongestHarmoniousSubsequence {

    /**
     * 暴力循环
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // flag处理全部值相同的情况, for循环内
            boolean flag = false;
            int cur = nums[i];
            int length = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == cur || nums[j] == cur+1) {
                    length++;
                    if (nums[j] != cur) {
                        flag = true;
                    }
                }
            }
            // flag为true才参与计算
            if (flag) {
                max = Math.max(length, max);
            }
        }
        return max;
    }

    public int findLHS1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap((int) (nums.length * 1.5));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (Integer num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }
        }
        return max;
    }

}
