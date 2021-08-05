package algorithm.leetcode.easy;

/**
 * @author initial.y
 * @className MergeSortedArray
 * @description
 * @date 2021/8/5
 * @num 88
 * @link https://leetcode-cn.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int mStart = 0, nStart = 0;
        int cur;
        while (mStart < m || nStart < n) {
            // 优先处理边界
            if (mStart == m) {
                cur=nums2[nStart];
                nStart++;
            } else if (nStart == n) {
                cur= nums1[mStart];
                mStart++;
            } else if (nums1[mStart] <= nums2[nStart]){
                cur = nums1[mStart];
                mStart++;
            } else {
                cur=nums2[nStart];
                nStart++;
            }
            arr[mStart + nStart - 1] = cur;
        }
        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2,3);
    }
}
