package tdd.args.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgSchemaSecondTest {

    @Test
    public void test_return_int_value() {
        assertEquals(new ArgSchemaSecond("int").getValue("8080"), 8080);
        // todo new ArgSchemaSecond("p").getValue("8080") p->type -> value
    }

    @Test
    public void test_return_boolean_value() {
        assertEquals(new ArgSchemaSecond("bool").getValue("true"), true);
    }

    @Test
    public void test_return_string_value() {
        assertEquals(new ArgSchemaSecond("str").getValue("str"), "str");
    }

}
