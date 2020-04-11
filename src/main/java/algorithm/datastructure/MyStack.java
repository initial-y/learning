package algorithm.datastructure;

/**
 * @ClassName MyStack
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public interface MyStack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
