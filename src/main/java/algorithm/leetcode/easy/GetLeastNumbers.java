package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Random;

/**
 * @author initial.y
 * @className GetLeastNumbers
 * @description
 * @date 2021/8/20
 * @num 剑指 40
 * @link https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = partition(arr, l, r);
        quickSort(arr, l, index - 1);
        quickSort(arr, index + 1, r);
    }


    private int partition(int[] arr, int l, int r) {
        int rand = l + new Random().nextInt(r - l + 1);
        swap(arr, l , rand);

        int index = l;
        for (int i = l + 1; i < arr.length; i++) {
            if (arr[i] < arr[l]) {
                index ++;
                swap(arr, i, index);
            }
        }
        swap(arr, l, index);

        return index;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
