package tdd.args.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @className: ArgCommandThirdTest
 * @date: 2020/1/15
 */
public class ArgCommandThirdTest {

    @Test
    public void should_return_normal_value() {
        assertEquals(new ArgCommandThird("-p 8080 -l true").getValue("p"), "8080");
        assertEquals(new ArgCommandThird("-p 8080 -l true").getValue("l"), "true");
    }

    @Test
    public void should_return_null_value() {
        assertNull(new ArgCommandThird("-p -l true").getValue("p"));
        assertNull(new ArgCommandThird("-p 8080 -l").getValue("l"));
    }

    @Test
    public void should_return_negative_value() {
        assertEquals(new ArgCommandThird("-p -8080 -l true").getValue("p"), "-8080");
        assertEquals(new ArgCommandThird("-l true -p -8080").getValue("p"), "-8080");
    }

}
