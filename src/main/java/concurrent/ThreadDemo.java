package concurrent;

/**
 * @className: ThreadDemo
 * @author: yangxin
 * @date: 2020/4/7
 */
public class ThreadDemo {

    private Integer intLock = 10;

    private void syncMethod1() throws InterruptedException {
        System.out.println(this.getClass().getDeclaredConstructors()[1].getName());
        synchronized (intLock) {
            System.out.println("method 1, enter sync");
            this.wait();
            intLock--;
            System.out.println("method 1, intLock = " + intLock);
        }
    }

    private void syncMethod2() throws InterruptedException {
        System.out.println(this.getClass().getDeclaredConstructors()[1].getName());
        synchronized (intLock) {
            System.out.println("method 2, enter sync");
            intLock--;
            System.out.println("method 2, intLock = " + intLock);
            this.notify();
        }
    }

}
