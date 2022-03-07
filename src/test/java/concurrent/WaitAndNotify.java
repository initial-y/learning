package concurrent;


import lombok.SneakyThrows;
import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaitAndNotify {
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(new ThreadA()).start();
//        Thread.sleep(1000);
//        new Thread(new ThreadB()).start();


        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100; i++) {
                        if (i % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            lock.wait();
                        } else {
                            lock.notifyAll();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100; i++) {
                        if (i % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            lock.wait();
                        } else {
                            lock.notifyAll();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }


    /**
     * 生产者-消费者模型
     */
    @Test
    public void test_blocking_queue() throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {
            while (true) {
                try {
                    blockingQueue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        System.out.println(blockingQueue.size());
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();

    }

    class WaitNotifyProductConsumer {

        private int maxSize = 10;

        LinkedList<Object> list = new LinkedList<>();

        public synchronized void put() throws InterruptedException {
            if (list.size() == maxSize) {
                System.out.println("put wait");
                wait();
            }
            list.add(new Object());
            notifyAll();
        }

        public synchronized void take() throws InterruptedException {
            if (list.size() == 0) {
                System.out.println("take wait");
                wait();
            }
            list.remove();
            notifyAll();
        }

    }

    @Test
    public void test_wait_notify_producer_consumer() throws InterruptedException {
        WaitNotifyProductConsumer waitNotifyProductConsumer = new WaitNotifyProductConsumer();
        waitNotifyProductConsumer.put();
        waitNotifyProductConsumer.take();
        waitNotifyProductConsumer.take();
        waitNotifyProductConsumer.take();
    }



}