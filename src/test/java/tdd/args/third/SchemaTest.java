package tdd.args.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchemaTest {

    @Test
    public void should_return_int_value() {
        assertEquals(new ArgSchema("int").getValue("8080"), 8080);
    }

    @Test
    public void should_return_bool_value() {
        assertEquals(new ArgSchema("bool").getValue("true"), true);
    }

    @Test
    public void should_return_str_value() {
        assertEquals(new ArgSchema("str").getValue("str"), "str");
    }

}
