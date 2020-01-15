package tdd.args.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * args第三遍
 * 耗时 : 约1.5h
 * 好的: tdd模式开发; 速度加快; 测试用例更全
 * 不好的: 测试圈定需求范围还不准确;schema使用了map;command使用对象封装后if层级还是过多
 * @ClassName: ArgParserThirdTest
 * @Date: 2020/1/15
 */
public class ArgParserThirdTest {

    @Test
    public void should_return_normal_value_if_command_has_normal_value() {
        assertEquals(new ArgParserThird("p:int;l:bool;d:str", "-p 8080 -d /usr/local -l").getValue("p"), 8080);
        assertEquals(new ArgParserThird("p:int;l:bool;d:str", "-p 8080 -d /usr/local -l").getValue("d"), "/usr/local");
        assertEquals(new ArgParserThird("p:int;l:bool", "-p 8080 -d /usr/local -l true").getValue("l"), Boolean.TRUE);
    }

    @Test
    public void should_return_default_value_if_command_without_value() {
        assertEquals(new ArgParserThird("p:int;l:bool", "-l -p 8080").getValue("l"), Boolean.TRUE);
        assertEquals(new ArgParserThird("p:int;l:bool", "-p 8080 -d /usr/local -l").getValue("l"), Boolean.TRUE);
    }

    @Test
    public void should_return_null_if_command_without_compatible_schema() {
        assertNull(new ArgParserThird("p:int;l:bool", "-p 8080 -d /usr/local -l").getValue("d"));
    }

    @Test
    public void should_return_negative_value_if_command_has_negative_value() {
        assertEquals(new ArgParserThird("p:int;l:bool", "-p -8080 -l true").getValue("p"), -8080);
        assertEquals(new ArgParserThird("p:int;l:bool", "-l true -p -8080").getValue("p"), -8080);
    }
}
