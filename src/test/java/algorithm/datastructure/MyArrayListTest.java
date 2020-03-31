package algorithm.datastructure;

import org.junit.Test;

/**
 * @ClassName MyArrayListTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/30
 */
public class MyArrayListTest {

    @Test
    public void test_add() {
        MyArray<Integer> myArray = new MyArray<>(10);
        for (int i = 1; i <= 10; i++) {
            myArray.addLast(i);
            System.out.println(myArray.toString());
        }

        myArray.addLast(10);
        System.out.println(myArray.toString());
        myArray.addFirst(-1);
        System.out.println(myArray.toString());
    }

    @Test
    public void test_get() {
        MyArray<Integer> myArray = new MyArray<>(10);
        for (int i = 1; i <= 10; i++) {
            myArray.addLast(i);
            System.out.println(myArray.toString());
        }
        System.out.println(myArray.get(5));
        System.out.println(myArray.getFirst());
        System.out.println(myArray.getLast());
    }

    @Test
    public void test_set() {
        MyArray<Integer> myArray = new MyArray<>(10);
        for (int i = 1; i <= 10; i++) {
            myArray.addLast(i);
            System.out.println(myArray.toString());
        }
        myArray.set(5, 66);
        System.out.println(myArray.toString());
    }

    @Test
    public void test_remove() {
        MyArray<Integer> myArray = new MyArray<>(10);
        for (int i = 1; i <= 10; i++) {
            myArray.addLast(i);
            System.out.println(myArray.toString());
        }
        myArray.remove(3);
        System.out.println(myArray.toString());

        myArray.removeFirst();
        System.out.println(myArray.toString());

        myArray.removeLast();
        System.out.println(myArray.toString());

        for (int i = 0; i < 5; i++) {
            myArray.removeLast();
        }
        System.out.println(myArray.toString());
    }
}
