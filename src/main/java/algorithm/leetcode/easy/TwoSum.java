package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author initial_y
 * @className TwoSum
 * @description
 * @date 2021/07/13
 * @num 1
 * @link https://leetcode-cn.com/problems/two-sum/description/
 */
public class TwoSum {

    /**
     * O(n^2)暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        // 题设元素不会重复出现
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            // 处理同一数字重复计算得情况
            if (map.get(another) != null && map.get(another) != i) {
                return new int[]{i, map.get(another)};
            }
        }
        return null;
    }

    /**
     * hash2
     * 题设要求返回下标可以不注重顺序, 可以先不存hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.get(another) != null && map.get(another) != i) {
                return new int[]{i, map.get(another)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
