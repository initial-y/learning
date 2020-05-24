package algorithm.datastructure;

/**
 * @ClassName IMyMap
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/5/24
 */
public interface IMyMap<K, V> {

    void add(K key, V value);

    V remove(K key);

    V get(K key);

    void set(K key, V newValue);

    boolean isEmpty();

    boolean contains(K key);

    int getSize();
}
