package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author initial.y
 * @className SortCharactersByFrequency
 * @description
 * @date 2021/8/23
 * @num 451
 * @link https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        if("".equals(s) || s == null) {
            return s;
        }

        char[] arr = s.toCharArray();
        Map<Character, Integer> charNumMap = new HashMap<>(s.length() * 2);
        for (char c : arr) {
            charNumMap.put(c, charNumMap.getOrDefault(c, 0) + 1);
        }

        Queue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return charNumMap.get(o2) - charNumMap.get(o1);
            }
        });
        for (Character character : charNumMap.keySet()) {
            priorityQueue.add(character);
        }
        char[] result = new char[s.length()];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.poll();
            int charNum = charNumMap.get(c);
            for (int j = 0; j < charNum; j++) {
                result[i++] = c;
            }
        }
        return String.valueOf(result);
    }

}
