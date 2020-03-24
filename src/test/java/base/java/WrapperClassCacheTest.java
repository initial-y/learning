package base.java;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @className: WrapperClassCacheTest
 * @author: yangxin
 * @date: 2020/3/24
 */
public class WrapperClassCacheTest {

    @Test
    public void test_wrapper_class_in_cache() {
        Integer cacheInteger1 = 127;
        Integer cacheInteger2 = 127;
        assertTrue(cacheInteger1 == cacheInteger2);
    }

    @Test
    public void test_wrapper_class_out_of_cache() {
        Integer int1 = 128;
        Integer int2 = 128;
        assertFalse(int1 == int2);
        assertTrue(int1.equals(int2));
    }

    @Test
    public void test_wrapper_class_and_basic_date_type() {
        int basicInt = 1;
        Integer wrapperInt = 1;
        // 自动装箱
        assertTrue(basicInt == wrapperInt);
    }

    /**
     * 基本类型, 包装类型比较
     */
    @Test
    public void test_wrapper_class_and_basic_date_type_with_cache() {
        int basicInt = 128;
        Integer wrapperInt = 128;
        //true 基本数据类型和包装类 == 比较，会先把包装类拆箱
        assertTrue(basicInt == wrapperInt);
        // true 基本数据类型和包装类 == 比较，会先把基本类型装箱(装箱后equals比较的值)
        assertTrue(wrapperInt.equals(basicInt));
    }

    /**
     * Integer.valueOf() 底层使用的new Integer()构造方法
     * Integer.parseInt() 返回 int 类型的值
     */
    @Test
    public void test_wrapper_class_value_of_method() {
        Integer inCacheInt1 = Integer.valueOf(127);
        Integer inCacheInt2 = Integer.valueOf(127);
        assertTrue(inCacheInt1 == inCacheInt2);

        Integer outOfCacheInt1 = Integer.valueOf(128);
        Integer outOfCacheInt2 = Integer.valueOf(128);
        assertFalse(outOfCacheInt1 == outOfCacheInt2);

        Integer inCacheStrInt1 = Integer.valueOf("127");
        Integer inCacheStrInt2 = Integer.valueOf("127");
        assertTrue(inCacheStrInt1 == inCacheStrInt2);

        Integer outOfCacheStrInt1 = Integer.valueOf("128");
        Integer outOfCacheStrInt2 = Integer.valueOf("128");
        assertFalse(outOfCacheStrInt1 == outOfCacheStrInt2);
    }
}
