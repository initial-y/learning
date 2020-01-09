package tdd.args.first;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName: ArgSchemaTest
 * @Date: 2020/1/9
 */
public class ArgSchemaTest {

    @Test
    public void should_return_bool() {
        assertEquals(new ArgSchema("l", "bool").getValue("true"), true);
    }

    @Test
    public void should_return_int() {
        assertEquals(new ArgSchema("p", "int").getValue("8080"), 8080);
    }

    @Test
    public void should_return_str() {
        assertEquals(new ArgSchema("d", "str").getValue("/usr/local"), "/usr/local");
    }
}
