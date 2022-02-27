package base.java;


import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className Test
 * @description 
 * @date 2021/04/28
 */
public class Tests {

    @Test
    public void testInterval() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime tomorrowStart = LocalDateTime.of(now.plusDays(1L).toLocalDate(), LocalTime.MIN);
        System.out.println(tomorrowStart);
        long minutes = Duration.between(now, tomorrowStart).getSeconds();
        System.out.println(minutes);

        LocalDateTime time = LocalDateTime.of(2021, 9, 10, 10,44, 55, 435);
        System.out.println(time.plusSeconds(47704 + 1));
    }


    @Test
    public void testCollectionSubtract() {
        List<Integer> cxList = Arrays.asList(1,2,3,4);
        List<Integer> chList = new ArrayList<>();
        List<Integer> diff = (List<Integer>) CollectionUtils.union(cxList, chList);
        System.out.println(CollectionUtils.subtract(cxList, chList));
    }

    @Test
    public void testSet() {
        Set<BigDecimal> set = new HashSet<>();
        set.add(new BigDecimal("0.130"));
        set.add(new BigDecimal("0.1300"));
        set = set.stream().map(BigDecimal :: stripTrailingZeros).collect(Collectors.toSet());
        System.out.println(set);
    }


    @Test
    public void testBigDecimal() {
        List<BigDecimal> c1 = Arrays.asList(new BigDecimal("0.13"), new BigDecimal("0.1100"));
        List<BigDecimal> c2 = Arrays.asList(new BigDecimal("0.09"), null);
        List<BigDecimal> union = (List<BigDecimal>) CollectionUtils.union(c1, c2);
//        List<BigDecimal> union = CollectionUtils.union(c1, c2).stream().map(BigDecimal::stripTrailingZeros).collect(Collectors.toList());
        System.out.println(union);
    }

    @Test
    public void testInteger() {
        Integer i = null;
        System.out.println(i==1);
    }

    @Test
    public void testMap() {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        Object[] arr = map.values().toArray();
        for (int i = 0; i < arr.length; i++) {
            int num = (int) arr[i];
            if (num > max) {
                max = num;
            }
        }

        int[] result = new int[max];
        int finalMax = max;
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        map.keySet().forEach(k -> {
            Integer v =map.get(k);
            if (v == finalMax) {
                list.add(k);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
    }


    @Test
    public void test() {
        String[] words = new String[]{"apple","iOS","dog","nana","man","good","goodman"};
        System.out.println(longestWord(words));
    }


    private HashMap<String, Integer> wordNumMap = new HashMap<>();
    private HashMap<String, Integer> wordLengthMap = new HashMap<>();
    public String longestWord (String[] words) {
        // write code here

        for (String word : words) {
            for (String s : words) {
                if (!word.equals(s) &&word.contains(s)) {
                    wordNumMap.put(word, wordNumMap.getOrDefault(word, 0) + 1);
                    wordLengthMap.put(word, wordLengthMap.getOrDefault(word, 0) + s.length());
                }
            }
        }

        Integer max = wordNumMap.values().stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(max);
        Arrays.sort(words);
        for (String word : words) {
            if (wordNumMap.getOrDefault(word, 0).equals(max)) {
                if (wordLengthMap.getOrDefault(word, 0).equals(word.length())) {
                    return word;
                }
            }
        }
        return "";
    }


    @Test
    public void testString() {
        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
        System.out.println(str1==str2.intern());
    }


}
