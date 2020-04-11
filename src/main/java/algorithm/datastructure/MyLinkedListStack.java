package algorithm.datastructure;

/**
 * @ClassName MyLinkedListStack
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyLinkedListStack<E> implements MyStack<E> {

    private MyDummyLinkedList linkedList;

    public MyLinkedListStack() {
        linkedList = new MyDummyLinkedList();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return (E) linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return (E) linkedList.getFirst();
    }

    @Override
    public String toString() {
        return "MyLinkedListStack{" +
                "linkedList=" + linkedList +
                '}';
    }
}
