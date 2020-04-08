package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: KthSmallestElement
 * @author: yangxin
 * @date: 2020/4/8
 * @see https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElement {

    /**
     *  time 10.54
     *  space 11.58
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        List<Integer> list = new ArrayList<>(2 * n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                list.add(matrix[i][j]);
            }
        }

        return list.stream().sorted().collect(Collectors.toList()).get(k - 1);
    }

    /**
     * 如何写出正确的程序：
     *      明确变量的含义
     *      循环不变量
     *      小数据量调试
     *      大数据量测试
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        // todo
        return 0;
    }

}
