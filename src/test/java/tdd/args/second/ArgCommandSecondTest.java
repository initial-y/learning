package tdd.args.second;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 测试用例不正确
 * @ClassName: ArgCommandSecondTest
 * @Date: 2020/1/14
 */
public class ArgCommandSecondTest {

    @Test
    public void test_normal_return() {
        assertEquals(new ArgCommandSecond("-p 8080 -l true").getValue("p"), "8080");
        assertEquals(new ArgCommandSecond("-p 8080 -l true").getValue("l"), "true");
    }

    @Test
    public void test_null_return() {
        assertNull(new ArgCommandSecond("-p 8080 -l").getValue("l"));
        assertNull(new ArgCommandSecond("-p 8080 -l -d /usr/local").getValue("l"));
    }

    @Test
    public void test_negative_value_return() {
        assertEquals(new ArgCommandSecond("-p -8080 -l true").getValue("p"), "-8080");
    }

    @Test
    public void test_regex() {
        String str = "-p 8080 -l true";
        System.out.println(new Gson().toJson(str.split("\\s+")));
    }
}
