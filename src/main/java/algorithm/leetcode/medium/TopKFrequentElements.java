package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author initial.y
 * @className TopKFrequentElements
 * @description
 * @date 2021/8/12
 * @num 347
 * @link https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numTimesMap = new HashMap<>(nums.length);
        for (int num : nums) {
            numTimesMap.put(num, numTimesMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>(k);
        List<Integer> list = new ArrayList<>(numTimesMap.keySet());
        for (int i = 0; i < list.size(); i++) {
            if (i < k) {
                priorityQueue.add(list.get(i));
            } else {
                if (numTimesMap.get(list.get(i)) > numTimesMap.get(priorityQueue.peek())) {
                    priorityQueue.poll();
                    priorityQueue.add(list.get(i));
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = priorityQueue.poll();
        }

        return ret;
    }

}
