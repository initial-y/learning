package concurrent;

/**
 * @author initial.y
 * @className Tests
 * @description
 * @date 2022/3/19
 */
public class Tests {


    public static void main(String[] args) throws InterruptedException {
        Object obe = new Object();

        Thread threadB = new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                synchronized (obe) {
                    obe.notify();
                    if (j % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + j);
                        try {
                            obe.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, "threadB");

        Thread threadA = new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                synchronized (obe) {
                    obe.notify();
                    if (j % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + j);
                        try {
                            obe.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, "threadA");

        threadB.start();

        threadA.start();

        Thread.sleep(10000);
    }

}
