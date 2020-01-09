package tdd.args.first;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @className: ArgCommandTest
 * @date: 2020/1/9
 */
public class ArgCommandTest {

    @Test
    public void should_return_normal_value() {
        assertEquals(new ArgCommand("-p 8080").getValue(), "8080");
        assertEquals(new ArgCommand("-d /usr/local").getValue(), "/usr/local");
    }

    @Test
    public void should_return_null_value() {
        assertNull(new ArgCommand("-l").getValue());
    }

    @Test
    public void should_return_negative_value() {
        assertEquals(new ArgCommand("-p -8080").getValue(), "-8080");
    }

    @Test
    public void test() {
        String command = "-p -8080";
        String[] commandArr = command.split("\\s+");
        System.out.println(new Gson().toJson(commandArr));
    }
}
