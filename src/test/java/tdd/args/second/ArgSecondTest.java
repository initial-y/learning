package tdd.args.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgSecondTest {

    @Test
    public void test_normal_value_cases() {
        ArgParserSecond argParser = new ArgParserSecond("p:int;l:bool;d:str", "-p 8080 -l true -d /usr/local");
        assertEquals(argParser.getValue("p"), 8080);
        assertEquals(argParser.getValue("l"), true);
    }

    @Test
    public void test_default_value_cases() {
        ArgParserSecond argParser = new ArgParserSecond("p:int;l:bool;d:str", "-p 8080 -l -d /usr/local");
        assertEquals(argParser.getValue("l"), true);
    }

    @Test
    public void test_negative_value_cases() {
        ArgParserSecond argParser = new ArgParserSecond("p:int;l:bool;d:str", "-p -8080 -d /usr/local");
        assertEquals(argParser.getValue("p"), 8080);
    }

    @Test
    public void test_without_schema_value_cases() {
        ArgParserSecond argParser = new ArgParserSecond("l:bool;d:str", "-p 8080 -l true -d /usr/local");
        assertEquals(argParser.getValue("p"), 8080);
    }
}
