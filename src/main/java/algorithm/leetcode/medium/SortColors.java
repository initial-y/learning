package algorithm.leetcode.medium;

/**
 * @ClassName SortColors
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/9
 * @num 75
 * @see https://leetcode-cn.com/problems/sort-colors/
 * @reference 88 215 167       125 344 345 11
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int[] numArr = new int[3];
        for (int i = 0; i < nums.length; i++) {
            numArr[nums[i]]++;
        }

        int k = 0;
        // todo extract
        for (int i = 0; i < numArr[0]; i++) {
            nums[k] = 0;
            k++;
        }
        for (int i = 0; i < numArr[1]; i++) {
            nums[k] = 1;
            k++;
        }
        for (int i = 0; i < numArr[2]; i++) {
            nums[k] = 2;
            k++;
        }

    }
    // todo 降低复杂度

}
