package tdd.args.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgParserThirdTest {

    @Test
    public void should_return_normal_value_if_command_has_normal_value() {
        assertEquals(new ArgParserThird("schema", "command").getValue("p"), 8080);
        assertEquals(new ArgParserThird("schema", "command").getValue("d"), "/usr/local");
        assertEquals(new ArgParserThird("schema", "command").getValue("l"), Boolean.TRUE);
    }

    @Test
    public void should_return_default_value_if_command_without_value() {
        assertEquals(new ArgParserThird("", "-l -p 8080").getValue("l"), Boolean.TRUE);
        assertEquals(new ArgParserThird("", "-p 8080 -d /usr/local -l").getValue("l"), Boolean.TRUE);
    }

    @Test
    public void should_return_null_if_command_without_compatible_schema() {
        assertEquals(new ArgParserThird("schema", "-p 8080 -d /usr/local -l").getValue("l"), null);
    }

    @Test
    public void should_return_negative_value_if_command_has_negative_value() {
        assertEquals(new ArgParserThird("schema", "-p -8080 -l true").getValue("p"), -8080);
        assertEquals(new ArgParserThird("schema", "-l true -p -8080").getValue("p"), -8080);
    }
}
