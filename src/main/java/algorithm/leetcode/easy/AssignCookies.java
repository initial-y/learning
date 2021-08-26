package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author xin.yang
 * @className AssignCookies
 * @description
 * @date 2021/08/24
 * @num 455
 */
public class AssignCookies {

    /**
     * 贪心算法
     * <p>
     *     保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
     * </p>
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, cnt = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                cnt++;
                i++;
            }
            j++;
        }
        
        return cnt;
    }
}
