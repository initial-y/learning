package algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @className ContainsDuplicate
 * @description 
 * @author intial.y
 * @date 2021/07/14
 * @num 217
 * @link https://leetcode-cn.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }
}
