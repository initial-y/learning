package concurrent;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @descrption 100个馒头，30个和尚，每个和尚最少吃一个馒头，最多不超过4个馒头
 * @ClassName CyclicBarrierTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/18
 */
public class CyclicBarrierTest {

    private volatile int totalBread = 100;

    @Test
    public void test_monk_eat_bread() throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(30);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                int bread = 0;
                bread++;
                totalBread--;
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                while (bread < 4 && totalBread > 0) {
                    bread++;
                    totalBread--;
                }
                System.out.println(Thread.currentThread().getName() + " eat " + bread + " bread");
            }).start();
        }
    }

}
