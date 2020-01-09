package tdd.args.first;

import com.google.gson.Gson;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * ArgFirst
 * 1. 需求拆分(10min):
 * - 输入正常的flag-value值, 获取flag返回正常的value值
 * - 输入没有value的flag值, 获取flag返回默认的value值
 * - 输入参数与解析后flag的参数不匹配, 返回null
 * - 输入负数value值, 获取负数value值
 * 2. 计时编码 > 4h
 * 3. TDD实现, 先测试后实现
 * <p>
 * 总结:
 * - 勉强使用tdd
 * - 拆分任务有问题
 * - 过于依赖正则
 *
 * @className: ArgFirstTest
 * @date: 2020/1/6
 */
public class ArgFirstTest {

    @Test
    public void should_return_value_if_command_is_normal() {
        ArgParser argParser = new ArgParser("l:bool;p:int;d:str", "-l true -p 8080 -d /usr/logs");
        assertEquals(argParser.getValue("p"), 8080);
        assertEquals(argParser.getValue("d"), "/usr/logs");
    }

    @Test
    public void should_return_default_if_command_without_value() {
        ArgParser argParser = new ArgParser("l:bool;p:int;d:str", "-l -p -d /usr/logs");
        assertEquals(argParser.getValue("p"), 0);
        assertEquals(argParser.getValue("l"), Boolean.FALSE);
    }

    @Test
    public void should_return_null_if_command_is_error() {
        ArgParser argParser = new ArgParser("l:bool;d:str", "-l -p 8888 -d /usr/logs");
        assertNull(argParser.getValue("p"));
        assertNull(argParser.getValue("z"));
    }

    @Test
    public void should_return_error_msg_if_command_contains_negative_value() {
        ArgParser argParser = new ArgParser("l:bool;p:int;d:str", "-l -p -8888 -d /usr/logs");
        assertEquals(argParser.getValue("p"), -8888);
    }

    @Test
    public void should_return_list_if_command_has_list_value() {
        ArgParser argParser = new ArgParser("g:strArr;d:intArr", "-g this,is,a,list -d 1,2,-3,5");
        assertThat(argParser.getValue("g"), is(new String[]{"this", "is", "a", "list"}));
        assertThat(argParser.getValue("d"), is(new int[]{1, 2, -3, 5}));
    }

    @Test
    public void test() {
        String str = "-l -p -8080 -d /usr/logs -d 1,2,-3,5";
        String[] args = str.split("^-|\\s+-(?!\\d)");

        System.out.println(args.length);
        System.out.println(new Gson().toJson(args));

    }
}
