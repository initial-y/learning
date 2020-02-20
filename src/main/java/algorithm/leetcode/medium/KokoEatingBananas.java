package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * leetcode 875
 * @ClassName KokoEatingBananas
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/19
 */
public class KokoEatingBananas {

    public int getMinEatingSpeed(int[] piles, int hours) {
        if (piles == null || piles.length == 0) {
            return -1;
        }
        long sum = Arrays.stream(piles).mapToLong(num -> (long) num).sum();
        int min = (int) Math.ceil((double) sum / hours);
        int max = Arrays.stream(piles).max().orElse(min);

        // 二分查找
        while (min < max) {
            int half = min + (max - min) / 2;
            int times = Arrays.stream(piles).boxed().mapToInt(pile -> (int) Math.ceil((double) pile / half)).sum();
            if (times <= hours) {
                max = half;
            } else {
                min = half + 1;
            }
        }

        return max;
    }


    public int minEatingSpeed(int[] piles, int hours) {
        if (piles == null || piles.length == 0) {
            return -1;
        }
        int max = 0;
        for (int p : piles) {
            max = max > p ? max : p;
        }
        int min = 0;

        // 二分查找
        while (min < max) {
            int half = min + (max - min) / 2;
            int times = 0;
            for (int p: piles) {
                times += (int) Math.ceil((double) p / half);
            }
            if (times <= hours) {
                max = half;
            } else {
                min = half + 1;
            }
        }

        return max;
    }

}
