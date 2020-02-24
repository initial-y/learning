package concurrent;

import org.junit.Test;

/**
 * @ClassName SyncTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/24
 */
public class SyncTest {

    @Test
    public void test_dead_lock() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            // synchronized特性，互斥锁（排它锁，独享锁，与之对应的是共享锁）：该锁一次只能被一个线程所持有
            synchronized (lock1) {
                System.out.println("thread1 lock1");
                try {
                    // 此处用sleep方法是为了增大出现死锁几率，不用也行，多试几次
                    // sleep方法不会释放锁
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // synchronized特性之，可重入锁：同一个线程在外层方法获取锁的时候，再进入该线程的内层方法会自动获取锁（前提锁对象得是同一个对象或者class），不会因为之前已经获取过还没释放而阻塞
                // 如果synchronized不是可重入锁，那么光是调用`thread1.start()`执行到这里就会阻塞，此时lock1没释放
                synchronized (lock2) {
                    System.out.println("thread1 lock2");
                }
            }

        });

        Runnable thread2 = () -> {
            synchronized (lock2) {
                System.out.println("tread2 lock2");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("thread2 lock1");
                }
            }
        };

        thread1.start();
        thread2.run();

    }

}
