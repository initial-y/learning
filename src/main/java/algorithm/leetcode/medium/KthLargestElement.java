package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName KthLargestElement
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/9
 * @num 215
 * @see https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>(nums.length * 2);
        for (int num : nums) {
            numsList.add(num);
        }
        return numsList.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList()).get(k - 1);
    }
    // todo 优化算法
}
