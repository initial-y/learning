package naver;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName NaverCachedData
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 */
public class NaverCachedData<E> {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.WriteLock wl = rwl.writeLock();
    private final ReentrantReadWriteLock.ReadLock rl = rwl.readLock();

    private Set cacheSet = new HashSet(10);

    /**
     * processCachedData
     * @param e
     * @return
     */
    public E processCachedData(E e) {
        E re;
        rl.lock();
        if (!isDataValid(e)) {
            try {
                // in cacheSet, return
                re = (E) cacheSet.stream()
                        .filter(c -> c.equals(e))
                        .findFirst()
                        .orElse(null);
                System.out.println("e is cached, e:" + e);
            } finally {
                rl.unlock();
            }
        } else {
            // not in cache, cache and return
            rl.unlock();
            wl.lock();
            try {
                cacheSet.add(e);
                System.out.println("cache e, e:" + e);
                // downgrade
                rl.lock();
                try {
                    E rle =  (E) cacheSet.stream()
                            .filter(c -> c.equals(e))
                            .findFirst()
                            .orElse(null);
                    System.out.println("after downgrade , e :" + e);
                    re = rle;
                } finally {
                    rl.unlock();
                }
            } finally {
                wl.unlock();
            }
        }
        return re;
    }

    /**
     * check data is in cacheSet
     * @param e
     * @return
     */
    private boolean isDataValid(E e) {
        E cache = (E) cacheSet.stream()
                .filter(c -> c.equals(e))
                .findFirst()
                .orElse(null);
        return cache == null;
    }


}
