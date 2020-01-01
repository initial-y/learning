package tdd.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * fizzbuzz第二遍，耗时约15min
 * tdd两大原则：
 * 1. 没有失败的测试就不能写代码
 * 2. 只能写刚好让测试通过的代码（1min内测试通过，10行代码之内通过）
 */
public class FizzBuzzSecondTest {

    @Test
    public void should_return_raw_num_if_num_is_normal() {
        checkNumOutput(1, "1");
        checkNumOutput(2, "2");
    }

    @Test
    public void should_return_fizz_if_num_is_divide_by_3() {
        checkNumOutput(3, "fizz");
        checkNumOutput(33, "fizz");
    }

    @Test
    public void should_return_buzz_if_num_is_divide_by_5() {
        checkNumOutput(5, "buzz");
        checkNumOutput(55, "buzz");
    }

    @Test
    public void  should_return_fizzbuzz_if_num_is_divide_by_3_and_5() {
        checkNumOutput(15, "fizzbuzz");
    }


    private void checkNumOutput(int i, String s) {
        assertThat(new FizzBuzzSecond(i).toString(), is(s));
    }
}
