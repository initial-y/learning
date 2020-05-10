package algorithm.datastructure;

/**
 * @ClassName MyLinkedListSet
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/5/10
 */
public class MyLinkedListSet<E> implements IMySet<E> {

    private MyDummyLinkedList<E> list;

    public MyLinkedListSet() {
        list = new MyDummyLinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void add(E e) {
        if (list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
}
