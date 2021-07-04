package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @ClassName SetMismatch
 * @Descripiton
 * @Author initial_yang
 * @Date 2021/7/4
 * @num 645
 * @link https://leetcode-cn.com/problems/set-mismatch/
 */
public class SetMismatch {

    // todo
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int[] result = new int[2];
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                result[0] = nums[i];
                result[1] = nums[i] + 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,4,2,2};
        findErrorNums(arr);
    }

}
