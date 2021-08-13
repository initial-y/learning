package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author initial.y
 * @className KthLargestElementInAnArray
 * @description
 * @date 2021/8/8
 * @num 215
 * @link https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    /**
     * 排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k + 1];
    }

    /**
     * 堆排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {

        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.add(nums[i]);
            } else {
                int top = minHeap.peek();
                if (top < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }

            }
        }
        return minHeap.peek();
    }

    /**
     * 快速排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }


    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high) {
        // 必须小于
        if (low < high) {
            int index = partition(arr, low, high);
            quickSort(arr, low, index -1);
            quickSort(arr, index + 1, high);
        }
    }

    /**
     * 分区算法,选出描定点
     * 默认时间复杂度O(nlogn), 递归深度O(logn)
     * <p>
     *     问题:arr完全有序时时间复杂度退化为O(n^2),递归深度O(n)
     * </p>
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
        // 默认描定点为low
        int index = low;
        // 从low+1开始遍历, 将数组分成大于等于描定点, 小于描定点的2份
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < arr[low]) {
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, low, index);
        return index;
    }

    /**
     * partition优化版, 使用Random随机数
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition1(int[] arr, int low, int high) {
        // 修改描定点为[low,high - low]间的随机值
        int index = low + new Random().nextInt(high - low + 1);
        swap(arr, low, index);
        index = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < arr[low]) {
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, low, index);
        return index;
    }

    private int partition2(int[] arr, int low, int high) {
        // 随机交换中间的元素
        swap(arr, low, low + (high - low) / 2);
        int index = low;
        for (int i = low + 1; i <= high ; i++) {
            if (arr[i] < arr[low]) {

            }
        }
        return index;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
