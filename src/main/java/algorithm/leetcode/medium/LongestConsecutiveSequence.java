package algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Map<Integer, Integer> numMap = new HashMap<>(nums.length * 2);
        List<Integer> numsList = IntStream.of(nums).boxed().sorted().collect(Collectors.toList());
        int prefix = numsList.get(0);
        int cnt = 1;
        for (int i = 1; i < numsList.size(); i++) {
            if (numsList.get(i) - prefix == 1) {
//                cnt
            }
        }
        return 0;
    }
}
