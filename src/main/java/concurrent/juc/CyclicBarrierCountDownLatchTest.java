package concurrent.juc;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier:
 *  - 一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行;
 *  - await()方法会阻塞线程
 *
 * CountDownLatch:
 *  - 一般用于某个线程 (比如main线程) 等待若干个其他线程执行完任务之后，它才执行;
 *  - countDown()方法不会阻塞线程, 只做计数用
 *
 * @author xin.yang
 * @className CyclicBarrierCountDownLatchTest
 * @description
 * @date 2021/09/08
 */
public class CyclicBarrierCountDownLatchTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
            () -> System.out.println("比赛开始"));
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("运动员入场");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Runnable t = new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String tName = Thread.currentThread().getName();
                    System.out.println("运动员" + tName + "入场");
                    // await()会阻塞线程
                    cyclicBarrier.await();
                    int time = random.nextInt(11);
                    Thread.sleep(time);
                    // countDown()不会阻塞线程
                    countDownLatch.countDown();
                    System.out.println("运动员" + tName + "到达终点, 耗时: " + time);
                }
            };
            service.execute(t);
        }
        service.shutdown();
        System.out.println("比赛结束");

    }

}
