package algorithm.datastructure;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName MyLoopQueueTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyLoopQueueTest {

    private MyLoopQueue<Integer> queue = new MyLoopQueue<>(10);

    @Test
    public void test_getSize() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
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
            System.out.println(queue);
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

    @Test
    public void test_loopQueue_and_arrayQueue_and_linkedListQueue() {
        int count = 100000;
        MyQueue arrayQueue = new MyArrayQueue(count);
        MyQueue loopQueue = new MyLoopQueue(count);
        MyQueue linkedListQueue = new MyLinkedListQueue();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arrayQueue.enqueue(random.nextInt());
            loopQueue.enqueue(random.nextInt());
            linkedListQueue.enqueue(random.nextInt());
        }
        System.out.println(getQueueRuntimeMillis(loopQueue, count));
        System.out.println(getQueueRuntimeMillis(arrayQueue, count));
        System.out.println(getQueueRuntimeMillis(linkedListQueue, count));

    }

    private long getQueueRuntimeMillis(MyQueue queue, int count) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
