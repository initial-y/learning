package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @ClassName MoveZeroes
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/8
 * @num 283
 * @see https://leetcode-cn.com/problems/move-zeroes/
 * @reference leetcode 27 26 80
 */
public class MoveZeroes {

    public void moveZeroesFirst(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }


    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int tmp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = tmp;
                }
                k++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
