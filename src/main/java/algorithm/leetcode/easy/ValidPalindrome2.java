package algorithm.leetcode.easy;

/**
 * @author initial.y
 * @className ValidPalindrome2
 * @description
 * @date 2021/8/4
 * @num 680
 * @link https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (start < end) {
            if (arr[start] != arr[end]) {
                // 无需对改变s
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String str, int start, int end) {
        char[] arr = str.toCharArray();
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

}
