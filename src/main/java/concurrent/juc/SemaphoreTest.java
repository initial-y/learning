package concurrent.juc;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * @author initial.y
 * @className SemaphoreTest
 * @description
 * @date 2022/01/06
 */
public class SemaphoreTest {

    static int threshold = 100000000;
    static int count = 0;
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Semaphore semaphore = new Semaphore(1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threshold; i++) {
            Runnable r1 = () -> addOne(semaphore);
            r1.run();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "millis");
        System.out.println(count);
    }

    @SneakyThrows
    public static void addOne(Semaphore semaphore) {
        semaphore.acquire();
        try {
            count++;
        } finally {
            semaphore.release();
        }

    }

}
