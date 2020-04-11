package algorithm.datastructure;

import org.junit.Test;

/**
 * @ClassName TestMyLinkedListQueue
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class TestMyLinkedListQueue {

    @Test
    public void test_myLinedListQueue() {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
        }

        for (int i = 0 ; i < 5; i++) {
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
