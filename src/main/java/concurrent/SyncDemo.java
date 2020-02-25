package concurrent;

/**
 * @ClassName SyncDemo
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/25
 */
public class SyncDemo {

    private final Object object = new Object();

    /**
     * javac -encoding utf-8 SyncDemo.java        javap -v SyncDemo.class
     *  public synchronized void synMethod();
     *     descriptor: ()V
     *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED // 标志符ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: ldc           #3                  // String 同步普通方法
     *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *          8: return
     *       LineNumberTable:
     *         line 12: 0
     *         line 13: 8
     */
    public synchronized void synMethod() {
        System.out.println("同步普通方法");
    }

    /**
     *  public static synchronized void synStaticMethod();
     *     descriptor: ()V
     *     flags: (0x0029) ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=0, args_size=0
     *          0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: ldc           #9                  // String 同步静态方法
     *          5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *          8: return
     *       LineNumberTable:
     *         line 120: 0
     *         line 121: 8
     */
    public synchronized static void synStaticMethod() {
        System.out.println("同步静态方法");
    }

    /**
     *public void synInstanceMethod();
     *     descriptor: ()V
     *     flags: (0x0001) ACC_PUBLIC
     *     Code:
     *       stack=2, locals=4, args_size=1
     *          0: new           #5                  // class java/lang/Object
     *          3: dup
     *          4: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          7: astore_1
     *          8: aload_1
     *          9: dup
     *         10: astore_2
     *         11: monitorenter
     *         12: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         15: ldc           #6                  // String 同步局部变量
     *         17: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         20: aload_2
     *         21: monitorexit
     *         22: goto          30
     *         25: astore_3
     *         26: aload_2
     *         27: monitorexit
     *         28: aload_3
     *         29: athrow
     *         30: return
     *       Exception table:
     *          from    to  target type
     *             12    22    25   any
     *             25    28    25   any
     *       LineNumberTable:
     *         line 32: 0
     *         line 34: 8
     *         line 35: 12
     *         line 36: 20
     *         line 37: 30
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255 / full_frame /
     *          offset_delta =25
     *          locals =[class concurrent/SyncDemo, class java/lang/Object,class java/lang/Object ]
     *          stack =[class java/lang/Throwable ]
     *         frame_type =250 /*chop /
     *          offset_delta =4
     *
     */
    public void synMthodVariable() {
        Object object = new Object();
        // 锁成员变量， 这里没什么意义，成员变量是线程私有的
        synchronized (object) {
            System.out.println("同步成员变量");
        }
    }

    /**
     *  public void synGlobleVariable();
     *     descriptor: ()V
     *     flags: (0x0001) ACC_PUBLIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: aload_0
     *          1: getfield      #3                  // Field object:Ljava/lang/Object;
     *          4: dup
     *          5: astore_1
     *          6: monitorenter
     *          7: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         10: ldc           #8                  // String 同步全局变量
     *         12: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         15: aload_1
     *         16: monitorexit
     *         17: goto          25
     *         20: astore_2
     *         21: aload_1
     *         22: monitorexit
     *         23: aload_2
     *         24: athrow
     *         25: return
     *         ···
     */
    public void synGlobleVariable() {
        synchronized (object) {
            System.out.println("同步全局变量");
        }
    }

}
