package algorithm.leetcode.easy;

/**
 * @author initial.y
 * @className TwoSum2
 * @description
 * @date 2021/8/4
 * @num 167
 * @link https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }
            if (sum > target) {
                end--;
            }
            if (sum < target) {
                start++;
            }
        }
        return null;
    }

}
