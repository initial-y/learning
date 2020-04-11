package algorithm.datastructure;

/**
 * @ClassName MyLinkedListQueue
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * T = O(1)
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        Node deNode = head;
        head = head.next;
        deNode.next = null;

        // 如果只有一个元素并且移除了
        if (head == null) {
            tail = null;
        }
        size--;
        return deNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        return "MyLinkedListQueue{" +
                "head=" + head.e +
                ", tail=" + tail.e +
                ", size=" + size +
                '}';
    }
}
