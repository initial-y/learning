package naver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @ClassName TestNaverArrayQueue
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 */
public class TestNaverArrayQueue {

    @Test
    public void test_push() {
        NaverQueue queue = new NaverArrayQueue(10);
        queue.push(1);
        assertEquals(queue.peek(), 1);
    }

    @Test
    public void test_pop() {
        NaverQueue queue = new NaverArrayQueue(10);
        queue.push(1);
        assertEquals(queue.pop(), 1);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_peek() {
        NaverQueue queue = new NaverArrayQueue(10);
        queue.push(1);
        assertEquals(queue.peek(), 1);
    }

    @Test
    public void test_isEmpty() {
        NaverQueue queue = new NaverArrayQueue(10);
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
    }


}
