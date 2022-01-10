package concurrent;

/**
 * @author initial.y
 * @className SynchronizedTest
 * @description
 * @date 2021/12/14
 */
public class SynchronizedTest {

    private long count = 0;

    public synchronized long get() {
        return count;
    }

    public synchronized void set(long v) {
        count = v;
    }

    public void add10K() {
//        synchronized (SynchronizedTest.class) {
            int idx = 0;
            while (idx++ < 10000) {
                // 存在竞态条件: set的结果依赖于get的结果
                set(get() + 1);
            }
//        }
    }


}
