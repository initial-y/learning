package algorithm.leetcode.medium;

import java.util.List;

/**
 * @author initial.y
 * @className LongestWordInDictionaryThroughDeleting
 * @description
 * @date 2021/8/6
 * @num 524
 * @link https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class LongestWordInDictionaryThroughDeleting {

    /**
     * 双指针
     * @param inputStr
     * @param dictionary
     * @return
     */
    public String findLongestWord(String inputStr, List<String> dictionary) {
        String longestWord = "";
        for (String curStr : dictionary) {
            // 双指针: i指向输入字符, j指向当前字典字符
            for (int i = 0, j = 0; i < inputStr.length() && j < curStr.length() ; i++) {
                // 如果输入字符=当前字典字符, j指针+1
                if (inputStr.charAt(i) == curStr.charAt(j)) {
                    j++;
                }
                // 如果在i走完之前j就能读满当前字符, 说明输入字符能够通过改造变成当前字典字符
                if (j == curStr.length()) {
                    // 题目要求: 最长字符
                    if (curStr.length() > longestWord.length()) {
                        longestWord = curStr;
                    } else if (curStr.length() == longestWord.length()) {
                        // 题目要求: 按最小字典排序
                        if (curStr.compareTo(longestWord) < 0) {
                            longestWord = curStr;
                        }
                    }
                }

            }
        }
        return longestWord;
    }
}
