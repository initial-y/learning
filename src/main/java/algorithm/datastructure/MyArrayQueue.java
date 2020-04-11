package algorithm.datastructure;

/**
 * @ClassName MyArrayQueue
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyArrayQueue<E> implements MyQueue<E> {

    private MyArray<E> array;

    public MyArrayQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    public MyArrayQueue() {
        array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * T = O(n), 可以用循环队列优化
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        return "MyArrayQueue{" +
                "array=" + array +
                '}';
    }
}
