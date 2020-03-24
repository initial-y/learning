package collection;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * @className: HashMapTest
 * @author: yangxin
 * @date: 2020/3/12
 */
public class HashMapTest {

    @Test
    public void test_hashmap() {
        HashMap map = new HashMap(4);
        map.put("str", 1);
//        assertEquals(map.get(1), 1);
    }
}
