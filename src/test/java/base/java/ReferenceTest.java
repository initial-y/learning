package base.java;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @className: ReferenceTest
 * @author: yangxin
 * @date: 2020/3/24
 */
public class ReferenceTest {

    @Test
    public void test_string_with_reference() {
        String referenceStr1 = "string";
        String referenceStr2 = "string";
        assertTrue(referenceStr1 == referenceStr2);
    }

    @Test
    public void test_string_with_reference_and_object() {
        String referenceStr = "str";
        String objectStr = new String("str");
        assertFalse(referenceStr == objectStr);
    }

    @Test
    public void test_string_equals_method() {
        String referenceStr = "str";
        String objectStr = new String("str");
        assertTrue(referenceStr.equals(objectStr));
    }

    @Test
    public void test_string_object() {
        String objectStr1 = new String("str");
        String objectStr2 = new String("str");
        assertFalse(objectStr1 == objectStr2);
        assertTrue(objectStr1.equals(objectStr2));
    }

    @Test
    public void test_string_intern_method() {
        String str = "str";
        String objectStr = new String("str");
        assertTrue(objectStr.intern() == str);
    }

}
