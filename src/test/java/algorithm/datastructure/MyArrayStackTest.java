package algorithm.datastructure;

import org.junit.Test;

/**
 * @ClassName MyArrayStackTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/11
 */
public class MyArrayStackTest {

    @Test
    public void test_push() {
        MyArrayStack stack = new MyArrayStack(5);
        for (int i = 0 ; i < 10 ; i++) {
            stack.push(i);
            System.out.println(stack.toString());
        }
    }

    @Test
    public void test_pop() {
        MyArrayStack stack = new MyArrayStack(5);
        for (int i = 0 ; i < 10 ; i++) {
            stack.push(i);
            System.out.println(stack.toString());
            if (i % 3 == 0) {
                System.out.println(stack.pop());
                System.out.println("after pop : " + stack.toString());
            }
        }
    }

    @Test
    public void test_peek() {
        MyArrayStack stack = new MyArrayStack(5);
        for (int i = 0 ; i < 10 ; i++) {
            stack.push(i);
            System.out.println(stack.peek());
            System.out.println(stack.toString());
        }
    }

}
