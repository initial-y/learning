package tdd.args.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Args 第二遍
 * 耗时大于1h
 * 好: 使用tdd的节奏更好; 速度有提升
 * 不好: schema需求没弄好; 测试用例覆盖不全; 使用Map; parser代码实现略复杂
 * 疑惑: 如何将tdd应用到平时的业务开发
 * @ClassName: ArgSecondTest
 * @Date: 2020/1/14
 */
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
        assertEquals(argParser.getValue("p"), -8080);
    }

    @Test
    public void test_without_schema_value_cases() {
        ArgParserSecond argParser = new ArgParserSecond("l:bool;d:str", "-p 8080 -l true -d /usr/local");
        assertNull(argParser.getValue("p"));
    }
}
