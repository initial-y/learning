package algorithm.leetcode.medium;

import java.util.Random;

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

    /**
     * 快速排序
     * @param nums
     */
    public void sortColors1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        // 0 inclusive , bound exclusive
        int rand = l + new Random().nextInt(r - l + 1);
        swap(nums, l, rand);

        int idx = l + 1;
        for (int i = l + 1; i < nums.length; i++) {
            if (nums[i] < nums[l]) {
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, l, idx - 1);
        return idx - 1;
    }

    /**
     * 双路快排 todo
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int partition2(int[] nums, int l, int r) {
//        int rand = l + new Random().nextInt(r - l + 1);
//        swap(nums, l, rand);

        int i = l + 1, j = r;
        while (i <= j) {
            while (i < j &&  nums[i] < nums[l]) {
                i++;
            }
            while (i < j && nums[j] > nums[l]) {
                j--;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
