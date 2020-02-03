package concurrent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName VolatileTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/3
 */
public class VolatileTest {

    @Test
    public void should_return_updated_value_while_volatile_write() {
        VolatileExample example = new VolatileExample();
        example.writer();
        assertTrue(example.flag);
    }

    @Test
    public void should_return_original_value_while_volatile_read() {
        VolatileExample example = new VolatileExample();
        example.reader();
        assertFalse(example.flag);
        assertEquals(example.a, 0);
    }
}
