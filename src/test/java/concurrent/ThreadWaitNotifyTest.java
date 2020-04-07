package concurrent;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: ThreadTest
 * @author: yangxin
 * @date: 2020/4/7
 */
public class ThreadWaitNotifyTest {

    private volatile Integer lock = 10;
    private AtomicInteger lock2 = new AtomicInteger(10);
    private Object lock3 = new Object();

    /**
     * 反例 lock
     */
    @Test
    public void test_wait_notify() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 inner");
            synchronized (lock) {
                System.out.println("t1 synchronized entered");
                try {
                    System.out.println("t1 call wait()");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 非原子操作
                lock--;
                System.out.println("t1, lock = " + lock);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("t2 inner");
            synchronized (lock) {
                lock--;
                System.out.println("t2, lock = " + lock);
                // 只调用notify() 不会释放锁
                lock.notify();
            }
        }, "t2");
        t1.start();
        // sleep() 只是为了保证t1.start()先于t2.start()执行
        Thread.currentThread().sleep(100L);
        t2.start();
    }


    /**
     * 正例
     */
    @Test
    public void test_wait_notify_2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 inner");
            synchronized (lock2) {
                System.out.println("t1 synchronized entered");
                try {
                    System.out.println("t1 call wait()");
                    lock2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 原子操作
                lock2.getAndDecrement();
                System.out.println("t1, lock = " + lock);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("t2 inner");
            synchronized (lock) {
                lock2.getAndDecrement();
                System.out.println("t2, lock = " + lock);
                // 只调用notify() 不会释放锁
                lock.notify();
            }
        }, "t2");
        t1.start();
        Thread.currentThread().sleep(100l);
        t2.start();

    }

    @Test
    public void test_wait_notify_3() throws InterruptedException {
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock3) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + ", i = " + i);
                        lock3.notify();
                        try {
                            lock3.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                lock.notify();
            }
        };

        Runnable t2 = () -> {
            synchronized (lock3) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ", i = " + i);
                    lock3.notify();
                    try {
                        lock3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        };

        new Thread(t1).start();
        Thread.sleep(1000);
        new Thread(t2).start();

    }

}
