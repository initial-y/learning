package concurrent;

import concurrent.jmm.JmmSingleton;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * @className: JmmTest
 * @author: yangxin
 * @date: 2020/3/10
 */
public class JmmTest {

    /**
     * 成员变量, 位于堆中, 所有线程共享
     */
    private int x = 0;

    private boolean commonBool = false;

    private volatile boolean volatileBool = false;

    /**
     * 测试多个线程操作同一个成员变量
     * JMM 特性: 内存可见性问题 + 线程切换 + 指令重排 + 编译优化
     * @throws InterruptedException
     */
    @Test
    public void test_multiple_threads_share_memory() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                // x++ 至少三条指令
                // 指令1, 从共享内存(堆)中取出x到线程私有的寄存器
                // 指令2, 将x+1
                // 指令3, 将结果写入内存(也有可能是缓存)
                x++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                x++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x);
        assertNotEquals(2000000, x);
    }

    /**
     * 测试非线程安全的单例
     */
    @Test
    public void test_jmm_singleton() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                /**
                 * 非线程安全情况多线程**可能**获取到未初始化完毕的单例
                 */
                JmmSingleton singleton = JmmSingleton.getInstance();
                System.out.println(singleton.getParam());
            }).start();
        }
    }

    /**
     * 测试多线程指令重排
     */
    @Test
    public void test_happens_before_reorder() {
        new Thread(this::writer).start();
        // 可能读到还没有被修改的值
        new Thread(this::reader).start();
    }

    private void writer() {
        x = 1;
        commonBool = true;
    }

    private void reader() {
        System.out.println(x);
        if (commonBool) {
            System.out.println(x);
        }
    }


    @Test
    public void test_happens_before_volatile() {
        new Thread(this::volatileWriter).start();
        // volatile规则 + 程序顺序规则 + 传递规则, 保证能读到写操作后的内容
        new Thread(this::volatileReader).start();
    }

    private void volatileWriter() {
        x = 1;
        volatileBool = true;
    }

    private void volatileReader() {
        System.out.println(x);
        if (volatileBool) {
            System.out.println(x);
        }
    }

    /**
     * 测试 happens-before start()规则
     */
    @Test
    public void test_happens_before_start() {
        Thread t2 = new Thread(() -> System.out.println(x));
        Thread t1 = new Thread(() -> {
            x = 6;
            // t1中调用t2的start(), 调用之前t1对成员变量的修改始终对t2可见
            t2.start();
        });
        t1.start();
    }

    @Test
    public void test_happens_before_join() throws InterruptedException {
        Thread t2 = new Thread(() -> x = 7);
        Thread t1 = new Thread(() -> {
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
        });
        t1.start();
    }
}
