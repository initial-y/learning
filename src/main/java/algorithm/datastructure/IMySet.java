package algorithm.datastructure;

public interface IMySet<E> {

    int getSize();

    boolean isEmpty();

    void add(E e);

    boolean contains(E e);

    void remove(E e);
}
