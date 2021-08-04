package algorithm.leetcode.easy;

/**
 * @author initial.y
 * @className SumOfSquareNumbers
 * @description
 * @date 2021/8/4
 * @num 633
 * @link https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 */
public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int) Math.ceil(Math.sqrt(c));
        while (start <= end) {
            int sum = (int) (Math.pow(start, 2) + Math.pow(end,2));
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                start++;
            }
            if (sum > c) {
                end--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(4));
    }

}
