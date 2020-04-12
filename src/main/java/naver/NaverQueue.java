package naver;

public interface NaverQueue<E> {

    /**
     * push enqueue
     * @param e
     */
    void push(E e);

    /**
     * pop dequeue
     * @return
     */
    E pop();

    /**
     * peek
     * @return
     */
    E peek();

    /**
     * isEmpty
     * @return
     */
    boolean isEmpty();
}
