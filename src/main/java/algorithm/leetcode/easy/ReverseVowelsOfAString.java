package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author initial.y
 * @className ReverseVowelsOfAString
 * @description
 * @date 2021/8/4
 * @num 345
 * @link https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {

        List<Character> vowels = Arrays.asList('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');

        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() -1;
        while (start < end) {
            if (vowels.contains(arr[start]) && vowels.contains(arr[end])) {
                char tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
            if (vowels.contains(arr[start]) && !vowels.contains(arr[end])) {
                end--;
            }
            if (!vowels.contains(arr[start]) && vowels.contains(arr[end])) {
                start++;
            }
            if (!vowels.contains(arr[start]) && !vowels.contains(arr[end])) {
                start++;
                end--;
            }

        }
        return String.valueOf(arr);
    }
}
