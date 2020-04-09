package algorithm.leetcode.medium;

/**
 * @className: RemoveDuplicates2
 * @author: yangxin
 * @date: 2020/4/9
 * @num 80
 * @see https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int sameNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                sameNum++;
                if (sameNum <= 2) {
                    nums[k] = nums[i];
                    k++;
                }
            } else {
                sameNum = 1;
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
