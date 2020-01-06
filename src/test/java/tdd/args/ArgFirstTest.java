package tdd.args;

import org.junit.Assert;
import org.junit.Test;
import tdd.args.first.ArgParam;
import tdd.args.first.ArgParser;
import tdd.args.first.ArgSchema;

import java.util.ArrayList;

/**
 * todo
 * 1. 需求拆分(10min):
 *  - 输入正常的flag-value值, 获取flag返回正常的value值
 *  - 输入没有value的flag值, 回去flag返回默认的value值
 *  - 输入参数与解析后flag的参数不匹配, 报错
 * 2. 计时编码
 * 3. TDD实现, 先测试后实现
 * @className: ArgFirstTest
 * @date: 2020/1/6
 */
public class ArgFirstTest {

    @Test
    public void should_return_value_if_input_is_normal() {
        Assert.assertEquals(new ArgParser(new ArgSchema(2, new ArrayList<ArgParam>())).parseText("-p 8080 -d /usr/logs").get("p"), 8080);
    }

    @Test
    public void should_return_default_if_input_without_value() {
        Assert.assertEquals(new ArgParser(new ArgSchema(2, new ArrayList<ArgParam>())).parseText("-l").get("p"), true);
    }

    @Test
    public void  should_return_error_msg_if_input_is_error() {

    }
}
