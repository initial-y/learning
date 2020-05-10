package algorithm.datastructure;

/**
 * @ClassName MyBstSet
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/5/10
 */
public class MyBstSet<E extends Comparable<E>> implements IMySet<E>  {

    private MyBST<E> bst;

    public MyBstSet() {
        this.bst = new MyBST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }
}
