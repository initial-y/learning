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

        // 最小堆
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 通过map.get比较次数
                return numTimesMap.get(o1) - numTimesMap.get(o2);
            }
        });
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
