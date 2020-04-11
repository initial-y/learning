package algorithm.datastructure;

import java.util.Arrays;

/**
 * @ClassName MyLoopQueue
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyLoopQueue<E> implements MyQueue<E> {

    private E[] data;

    /**
     * 队首索引
     */
    private int front;

    /**
     * 队尾索引
     */
    private int tail;

    /**
     * 队列大小， 可通过front ,tail 计算
     */
    private int size;

    public MyLoopQueue(int capacity) {
        // 循环队列会浪费一个空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public MyLoopQueue() {
        this(0);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 循环队列满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * T = O(1) 有缩容就均摊
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size < getCapacity() >> 2 && getCapacity() >> 1 != 0) {
            resize(getCapacity() >> 1);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        return data[front];
    }

    @Override
    public String toString() {
        return "MyLoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                ", capacity=" + getCapacity() +
                '}';
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        // 另一种遍历
        for (int i = front; i != tail; i = (i + 1) % data.length) {

        }

        data = newData;
        front = 0;
        tail = size;
    }
}
