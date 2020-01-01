package tdd.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FizzBuzzFirstTest {

    /**
     * step 1, 最简单情况: 普通数据返回初始值
     * 运行所有测试用例快捷键: ctrl + shift + F10
     */
    @Test
    public void should_show_raw_num_if_it_is_normal() {
        /**
         * extract method快捷键: ctrl + alt + m
         */
        checkNumOutput(1, "1");
        checkNumOutput(2, "2");
    }

    /**
     * step 2, 被3整除返回"fizz"
     */
    @Test
    public void should_show_fizz_if_it_is_divide_by_3() {
        checkNumOutput(3, "fizz");
    }

    /**
     * step 3, 被5整除返回"5"
     */
    @Test
    public void should_show_buzz_if_it_is_divide_by_5() {
        checkNumOutput(5, "buzz");
    }

    /**
     * step 4, 同时能被3或5整除返回"fizzbuzz"
     */
    @Test
    public void should_show_fizzbuzz_if_it_is_divide_by_3_and_5() {
        checkNumOutput(15, "fizzbuzz");
    }

    /**
     * bonus, 新需求: 包含3返回"fizz", 包含5返回"buzz", 同时包含3和5返回"fizzbuzz"
     */
    @Test
    public void show_show_fizzbuzz_if_it_contains_3_or_5() {
        checkNumOutput(13, "fizz");
        checkNumOutput(15, "fizzbuzz");
        checkNumOutput(51, "fizzbuzz");
        checkNumOutput(53, "fizzbuzz");
        checkNumOutput(56, "buzz");
    }

    @Test
    public void test_all_cases() {
        checkNumOutput(1, "1");
        checkNumOutput(2, "2");
        checkNumOutput(3, "fizz");
        checkNumOutput(5, "buzz");
        checkNumOutput(15, "fizzbuzz");
    }

    private void checkNumOutput(int i, String s) {
        assertThat(new FizzBuzzFirst(i).toString(), is(s));
    }

}
