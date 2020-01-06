package tdd.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FizzBuzz+新需求 大约 9min
 * 使用junit5
 * @className: FizzBuzzForthTest
 * @date: 2020/1/6
 */
public class FizzBuzzForthTest {

    /**
     * ParameterizedTest, CsvSource 依赖junit-jupiter-params
     * @param input
     * @param output
     */
    @ParameterizedTest(name = "give_{0}_should_return_{1}")
    @CsvSource({
            "1, '1'",
            "2, '2'",
            "3, 'fizz'",
            "5, 'buzz'",
            "15, 'fizzbuzz'",
            "52, 'buzz'",
            "53, 'fizzbuzz'"
    })
    public void testFizzBuzz(int input, String output) {
        assertThat(new FizzBuzzForth(input).toString(), is(output));
    }

}
