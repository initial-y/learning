package tdd.fizzbuzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * FizzBuzz Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12, 27, 2019</pre>
 */
public class FizzBuzzTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: printFizzBuzz(int n)
     */
    @Test
    public void testPrintFizzBuzz() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.printFizzBuzz(100);
//        fizzBuzz.printFizzBuzz(-1);
//        fizzBuzz.printFizzBuzz(1000);
    }


} 
