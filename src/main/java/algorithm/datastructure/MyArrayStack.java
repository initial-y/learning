package algorithm.datastructure;

/**
 * @ClassName MyArrayStack
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyArrayStack<E> implements MyStack<E> {

    private MyArray<E> array;

    public MyArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    public MyArrayStack() {
        // this(0) 不能用
        array = new MyArray<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "MyArrayStack{" +
                "array=" + array +
                '}';
    }
}
