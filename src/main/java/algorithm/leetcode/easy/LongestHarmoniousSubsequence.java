package algorithm.leetcode.easy;

/**
 * @className LongestHarmoniousSubsequence
 * @description 
 * @author xin.yang
 * @date 2021/07/16
 * @num 594
 * @link https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int max = 0;
        // todo 处理全部值相同的情况
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int length = 0;
            for (int j = i + 1; i < nums.length; i++) {
                if (nums[j] == cur || nums[j] == cur+1) {
                    length++;
                }
            }
            max = Math.max(length, max);
        }
        return max;
    }

}
