package algorithm.datastructure;

import java.util.Arrays;

/**
 * @ClassName MyArray
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/30
 */
public class MyArray<E> {

    private E[] data;

    private int size;

    public MyArray(int capacity) {
        data = (E[]) new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(E e) {
        // size
        this.add(size, e);
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        if (size == data.length) {
            resize(data.length << 1);
        }
        // i = size - 1
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        return data[index];
    }

    public E getFirst() {
        return data[0];
    }

    public E getLast() {
        // last index = size - 1;
        return data[size - 1];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        data[index] = e;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        // todo
        return null;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }


    /**
     * 扩容
     * @param newSize
     */
    private void resize(int newSize) {
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }
}
