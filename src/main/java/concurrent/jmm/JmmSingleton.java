package concurrent.jmm;

/**
 * 双重检查锁定, 构造非线程安全的单例
 * @className: JmmSingleton
 * @author: yangxin
 * @date: 2020/3/10
 */
public class JmmSingleton {

    /**
     * 私有成员变量
     */
    private static JmmSingleton singleton;

    private String param = "singleton";

    public String getParam() {
        return param;
    }

    /**
     * 私有的构造方法
     */
    private JmmSingleton() {
        super();
    }

    /**
     * 共有 + 静态的获取单例的方法
     * @return
     */
    public static JmmSingleton getInstance() {
        if (singleton == null) {
            synchronized (JmmSingleton.class) {
                // 如果私有成员变量singleton不用volatile修饰会可能会出现线程问题
                /**
                 * new操作步骤:
                 * 1. 分配内存M
                 * 2. 在M上初始化JmmSingleton对象
                 * 3. 将JmmSingleton对象赋值给singleton变量
                 * 其中2,3步可能会发生重排序, 如果执行顺序是1->3->2, 很有可能在没有初始化完毕时被其他线程访问到,产生NPE异常
                 */
                if (singleton == null) {
                    singleton = new JmmSingleton();
                }
            }
        }
        return singleton;
    }

}
