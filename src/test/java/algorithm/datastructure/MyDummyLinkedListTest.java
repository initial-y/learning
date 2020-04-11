package algorithm.datastructure;

import org.junit.Test;

/**
 * @ClassName MyDummyLinkedListTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyDummyLinkedListTest {

    @Test
    public void test_linkedList() {
        MyDummyLinkedList<Integer> linkedList = new MyDummyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.add(2, 222);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
