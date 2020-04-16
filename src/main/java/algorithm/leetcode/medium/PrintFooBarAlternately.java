package algorithm.leetcode.medium;

/**
 * @ClassName PrintFooBarAlternately
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/15
 * @no 1115
 * @see https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class PrintFooBarAlternately {

    private int n;

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo() {
        for (int i = 0; i < n; i++) {
            System.out.print("foo");
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            System.out.print("bar");
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }

}
