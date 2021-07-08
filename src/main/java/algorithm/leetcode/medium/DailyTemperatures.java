package algorithm.leetcode.medium;

/**
 * @className DailyTemperatures
 * @description 
 * @author xin.yang
 * @date 2021/07/08
 * @num 739
 * @link https://leetcode-cn.com/problems/daily-temperatures
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] resultArr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i+1;
            while (j < temperatures.length - 1) {
                if (temperatures[j] > temperatures[i]) {
                    resultArr[i] = j;
                    break;
                } else {
                    j++;
                }
            }
            resultArr[i] = 0;
        }

        return resultArr;
    }
}
