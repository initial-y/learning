package concurrent;

import org.junit.Test;

/**
 * @ClassName AQSTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/10
 */
public class AQSTest {

    static int count = 0;
    static AQSExample aqsExample = new AQSExample();

    @Test
    public void testAQS() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                aqsExample.lock();
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                aqsExample.unlock();
            }

        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        // todo  观察输出
        System.out.println(count);
        thread2.join();
        System.out.println(count);
    }

}
