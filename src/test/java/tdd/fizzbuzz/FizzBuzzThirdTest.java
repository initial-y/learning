package tdd.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 加上新需求大概15min
 * 测试用例的expect和actual要想清楚
 */
public class FizzBuzzThirdTest {

    @Test
    public void should_return_raw_num_if_num_is_normal() {
        checkNumOutput(1, "1");
        checkNumOutput(2, "2");
    }

    @Test
    public void should_return_fizz_if_num_is_divide_by_3() {
        checkNumOutput(3, "fizz");
    }

    @Test
    public void should_return_buzz_if_num_is_divide_by_5() {
        checkNumOutput(5, "buzz");
    }

    @Test
    public void should_return_fizzbuzz_if_num_is_divide_by_3_and_5() {
        checkNumOutput(15, "fizzbuzz");
    }

    @Test
    public void should_return_fizz_if_num_is_contains_3() {
        checkNumOutput(13, "fizz");
        checkNumOutput(43, "fizz");
    }

    @Test
    public void should_return_buzz_if_num_is_contains_5() {
        checkNumOutput(52, "buzz");
    }

    @Test
    public void should_return_fizzbuzz_if_num_is_contains_3_and_5() {
        checkNumOutput(53, "fizzbuzz");
    }

    private void checkNumOutput(int i, String s) {
        assertThat(new FizzBuzzThird(i).toString(), is(s));
    }

}
