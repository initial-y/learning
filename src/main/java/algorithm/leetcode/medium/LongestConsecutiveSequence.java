package algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xin.yang
 * @className LongestConsecutiveSequence
 * @description
 * @date 2021/08/02
 * @num 128
 * @link https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = num;
                int curLength = 1;

                while (numSet.contains(cur + 1)) {
                    cur++;
                    curLength++;
                }

                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}
