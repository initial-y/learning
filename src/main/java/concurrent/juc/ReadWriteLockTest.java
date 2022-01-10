package concurrent.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author initial.y
 * @className ReadWriteLockTest
 * @description 读写锁实现缓存
 * @date 2022/01/07
 */
public class ReadWriteLockTest<K, V> {

    private final Map<K, V> map = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();;
    private final Lock writeLock = lock.writeLock();

    public V get(K key) {
        V value = null;
        // 读锁查询, 可多个线程获取读锁
        readLock.lock();
        try {
            value = map.get(key);
        } finally {
            readLock.unlock();
        }
        // 缓存不为空
        if (value != null) {
            return value;
        }
        // 缓存为空, 查数据库并写入, 此时只会有一个线程获取写锁
        writeLock.lock();
        try {
            // 模拟查询数据库
            value = map.get(key);
            // double check: 读锁可以多个线程获取, 避免多线程情况下重复查询数据库
            if (value == null) {
                value = getFromDB(key);
                map.put(key,value);
            }
        } finally {
            writeLock.unlock();
        }
        return value;
    }

    private V getFromDB(K key) {
        V value = (V) new Object();
        return value;
    }

}
