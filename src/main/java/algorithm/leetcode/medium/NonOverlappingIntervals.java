package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xin.yang
 * @className NonOverlappingIntervals
 * @description
 * @date 2021/08/24
 * @num 435
 */
public class NonOverlappingIntervals {

    /**
     * 贪心算法
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按右边界排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 当前的左边界与前一个节点的右边界比较
            if (intervals[i][0] >= prev[1]) {
                cnt++;
                prev = intervals[i];
            }
        }
        return intervals.length - cnt;
    }
}
