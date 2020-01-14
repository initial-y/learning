package tdd.args.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 需求没整清楚, 缺少解析schemaStr这一步
 * 1. 解析schemaStr
 * 2. 根据key获取type
 * 3. 根据type和传入的值确定返回类型
 * @ClassName: ArgSchemaSecondTest
 * @Date: 2020/1/14
 */
public class ArgSchemaSecondTest {

    @Test
    public void test_return_int_value() {
        assertEquals(new ArgSchemaSecond("p:int;l:bool").getValue("p","8080"), 8080);
        //  new ArgSchemaSecond("type").getValue("8080") p->type -> value
    }

    @Test
    public void test_return_boolean_value() {
        assertEquals(new ArgSchemaSecond("p:int;l:bool").getValue("l","true"), true);
    }

    @Test
    public void test_return_string_value() {
        assertEquals(new ArgSchemaSecond("p:int;l:bool;d:str").getValue("d", "str"), "str");
    }

    @Test
    public void test_return_null_value() {
        assertNull(new ArgSchemaSecond("p:int;l:bool").getValue("g", "test"));
    }
}
