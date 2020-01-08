package tdd.args.first;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * todo
 * 1. 需求拆分(10min):
 * - 输入正常的flag-value值, 获取flag返回正常的value值
 * - 输入没有value的flag值, 获取flag返回默认的value值
 * - 输入参数与解析后flag的参数不匹配, 报错
 * 2. 计时编码
 * 3. TDD实现, 先测试后实现
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
    public void should_return_error_msg_if_command_is_error() {

    }

    @Test
    public void should_return_error_msg_if_command_contains_negative_value() {

    }

    @Test
    public void test() {
        String str = "-p 8080 -d /usr/logs";
        String[] args = str.split("(^\\s+)|(\\s-)");

        System.out.println(args.length);
        System.out.println(new Gson().toJson(args));

    }
}
