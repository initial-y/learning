package algorithm.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName MyArrayQueueTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyArrayQueueTest {

    private MyArrayQueue<Integer> queue = new MyArrayQueue<>(10);

    @Test
    public void test_getSize() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(queue.getSize(), 10);
    }

    @Test
    public void test_enqueue() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
    }

    @Test
    public void test_dequeue() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
            System.out.println(queue);
        }
    }

    @Test
    public void test_getFront() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
            System.out.println(queue.toString());
            System.out.println(queue.getFront());
        }
    }
}
