package algorithm.datastructure;

/**
 * @ClassName MyLinkedList
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyLinkedList<E> {

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

    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头部增加
     * @param e
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        // 等价于 head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index  error");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            // 注意 找 需要插入index位置的前一个节点 i < index - 1
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
//            // 等价于
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }
}
