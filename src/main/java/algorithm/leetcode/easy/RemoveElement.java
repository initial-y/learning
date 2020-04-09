package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @className: RemoveElement
 * @author: yangxin
 * @date: 2020/4/9
 * @num 27
 * @see https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

}
