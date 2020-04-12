package naver;

/**
 * @ClassName NaverArrayQueue
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 */
public class NaverArrayQueue<E> implements NaverQueue<E> {

    /**
     * queue data
     */
    private E[] data;

    /**
     * queue size
     */
    private int size;

    public NaverArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public NaverArrayQueue() {
        data = (E[]) new Object[10];
    }

    @Override
    public void push(E e) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size] = e;
        size++;
    }

    private void resize(int newSize) {
        E[] resizeData = (E[]) new Object[newSize];
        for (int i = 0; i < size ; i++) {
            resizeData[i] = data[i];
        }
        data = resizeData;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new IllegalArgumentException("empty queue");
        }
        E removeNode = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removeNode;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("empty queue");
        }
        return data[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
