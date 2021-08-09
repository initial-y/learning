package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        return 0;
    }

}
