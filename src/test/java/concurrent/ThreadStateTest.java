package concurrent;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @ClassName ThreadStateTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/7/27
 */
public class ThreadStateTest {

    @Test
    public void blockedTest() {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
//        try {
//            Thread.sleep(1000L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    @Test
    public void test() {
        IntStream.range(1, 1000).forEach(i -> {
            System.out.println("----" + i + "----");
            this.blockedTest();
        });
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
