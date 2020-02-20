package algorithm.leetcode.medium;

import org.junit.Test;

/**
 * @ClassName KokoEatingBananasTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/20
 */
public class KokoEatingBananasTest {

    @Test
    public void test_koko_eating_bananas() {
        KokoEatingBananas demo = new KokoEatingBananas();
        int[] bananas = {3,6,7,11};
        int hours = 8;
        int speed = demo.minEatingSpeed(bananas, hours);
        System.out.println(speed);
    }

}
