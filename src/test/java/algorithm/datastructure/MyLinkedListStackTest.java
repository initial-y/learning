package algorithm.datastructure;

import org.junit.Test;

/**
 * @ClassName MyLinkedListStackTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyLinkedListStackTest {

    @Test
    public void test_linkedListStack() {
        MyLinkedListStack stack = new MyLinkedListStack();
        for (int i = 0 ; i < 10 ; i++) {
            stack.push(i);
            System.out.println(stack.peek());
            System.out.println(stack.toString());
        }

        for (int i = 0 ; i < 5; i++) {
            stack.pop();
            System.out.println(stack.toString());
        }
    }
}
