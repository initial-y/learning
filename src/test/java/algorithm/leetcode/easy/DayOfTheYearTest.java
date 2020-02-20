package algorithm.leetcode.easy;

import org.junit.Test;

/**
 * leetcode 1154
 * @ClassName DayOfTheYearTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/20
 */
public class DayOfTheYearTest {

    @Test
    public void test_day_of_the_year() {
        DayOfTheYearDemo demo = new DayOfTheYearDemo();
        int days = demo.getDayOfYear("2016-02-29");
        System.out.println(days);
    }

}
