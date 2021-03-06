# Java内存模型

## 简述

Java虚拟机定义了一种内存模型（JMM）来屏蔽掉各种硬件系统和操作系统的访问差异，让Java程序在各种平台上都能达到一致的内存访问效果。

JMM是围绕在并发过程中如何处理原子性、可见性、有序性这三个特征而建立的，解决了三个问题就解决了缓存不一致问题。

> 原子性：Java中对基本类型的读取和赋值操作是原子性操作，这些操作不可中断，要么做完，要么不做。
>
> ```Java
> i = 1; // 赋值操作，只有一个步骤，原子操作
> j = i; // 两步操作，第一步读取i的值，第二步赋值，非原子操作
> i++; // i = i + 1, 读取i，+ 1，赋值三步操作，非原子操作
> ```
>
> JMM只实现了基本的原子性。如果要保证多个步骤操作的原子性，那就必须借助于`synchronized`或`Lock`来保证整块代码的原子性。

> 可见性：线程的工作内存和主内存之间存在着可见性的问题。
>
> Java利用`volatile`来保证可见性。当一个变量被`volatile`修饰时，线程对该变量的修改会立即刷新到主内存，当其他线程需要读取该变量时，会去主内存中读取刷新后的值（happens-before）。
>
> 除了`volatile`之外，`synchornized`关键字和`Lock`接口加锁也能保证代码块的原子性，但相对于`volatile`关键字而言开销更大。

> 有序性：JMM在基于as-if-serial语义的基础上，允许编译器和处理器对指令进行重排。
>
> >  as-if-serial语义：不管怎么重排序，程序的执行结果不能改变。
>
> JMM保证了指令重排不会影响到**单线程**的执行，但在多线程中容易出现问题。

> volatile只能保证可见性和有序性。

## Java内存区域
### 运行时数据区
![运行时数据区](imgs/JVM内存划分.jpg))

- 线程共享区
    - 堆空间(Heap)：JVM规范中对顶，所有对象实例（new创建的对象）及数组都要再堆上进行分配。
    > 一般来说，堆空间都有一个默认大小（具体取决于JVM实现），可以根据需要动态扩展
    > 
    > 当创建对象需要再堆上分配空间，并且堆本身的空间不够无法申请额外的内存空间，会抛出**OutOfMemory**异常。

    - 方法区(Method Area)：存储已被JVM加载的类信息/常量和静态变量等数据。
    >  方法区与堆一样是线程共享区域。用于存储已被虚拟机加载的类信息/常量/静态变量/即时编译器编译后的代码等数据。
    > 
    > **静态域**和**常量池**（Runtime Constant Pool）就是方法区的一部分。
    
- 每个线程独有的内存空间
    - 程序计数器：每个线程都有一个程序计数器，用来表示线程当前需要执行的Java指令地址（这里指的是JVM内存空间地址）。
    > 虽然很多程序都是多线程的，但是通常都只有一个处理器，一个时刻只能执行一个线程。因为线程间切换十分迅速，所以给我们一种多线程的假象。
    > 
    > 假如一个线程1执行到某一指令被挂起，切换到线程2。线程2执行完需要切换到1，此时处理器必须知道线程1上次执行到哪个指令才能从中断处恢复。线程1存放上次执行到哪个指令的地址就叫程序计数器。
    
    - 栈（Stack）：
        - 虚拟机栈：JVM在执行一个线程的方法时，会为这个线程方法创建一个栈帧（可以理解为JVM栈空间中的一段存储区域）。这个栈帧用于存储局部变量表/操作数栈/动态链接和方法入口信息。
            - 局部变量表：存放了编译器可知的各种基本数据类型（byte short boolean char int float double long）的变量，对象引用类型（reference类型）。
            > 对象引用不等同于对象本身，根据不同虚拟机的实现，可能会是一个只想对象起始地址的引用指针，也可能会是指向一个代表对象的句柄或者其他与此对象相关的位置。
        
        - 本地方法栈：与虚拟机栈空间类似，与之不同的时本地方法栈用来存储本地方法调用的相关信息。
        > 与虚拟机栈区别：
        >   - 虚拟机栈为虚拟机执行Java方法（字节码）服务
        > - 本地方法栈为虚拟机使用到的本地方法服务

#### 堆中的内存不可见问题
> 虽然堆是线程共享的，但是在现代计算机中，为了高效率往往会在高速缓存区中缓存共享变量，CPU访问缓存比访问内存快很多。正是因为缓存的存在，所以在多线程访问共享变量的时候，就产生了内存可见性的问题。
> 
> 线程之间的共享变量存在主内存中，每个线程都有一个私有的本地内存，存储了该线程以读、写共享变量的副本。本地内存是Java内存模型的一个抽象概念，并不真实存在。它涵盖了缓存、写缓冲区、寄存器等。

## Java内存模型（JMM）

> Java线程之间的通信由Java内存模型控制。从抽象的角度来说，JMM定义了线程和主内存之间的抽象关系。
>
> 现代计算机体系大部是采用的对称多处理器的体系架构。每个处理器均有独立的寄存器组和缓存，多个处理器可同时执行同一进程中的不同线程，这里称为处理器的乱序执行。
>
> 在Java中，不同的线程可能访问同一个共享或共享变量。如果任由编译器或处理器对这些访问进行优化的话，很有可能出现无法想象的问题，这里称为编译器的重排序。除了处理器的乱序执行、编译器的重排序，还有内存系统的重排序。因此Java语言规范引入了Java内存模型，通过定义多项规则对**编译器（限制重排序，保证有序行）**和**处理器（限制CPU缓存，保证可见性）**进行限制，主要是针对**可见性和有序性**。

JMM抽象示意图：
![JMM抽象示意图](imgs/JMM抽象示意图.jpg)
由图可见：

- 共享变量都是存在主内存中
- 每个线程保存了主内存共享变量的副本
- 如果线程A与线程B之间要通信的话，必须经历下面2个步骤：
    - 线程A将本地内存A中更新过的共享变量刷新到主内存中去。
    - 线程B到主内存中去读取线程A之前已经更新过的共享变量。

所以，线程间通信，必须经过主内存。  

另外，根据JMM的规定，线程对共享变量的所有操作都必须在自己的本地内存中进行，不能直接从主内存中读取。

JMM通过控制主内存与每个线程的本地内存之间的交互，来提供内存可见性保证。
> - Java中的`volatile`关键字可以保证多线程操作共享变量的可见性以及禁止指令重排序
> - synchronized关键字不仅保证可见性，同时也保证了原子性（互斥性）。

在更底层，JMM通过内存屏障来实现内存的可见性以及禁止重排序。为了程序员的方便理解，提出了`happens-before`，它更加的简单易懂，从而避免了程序员为了理解内存可见性而去学习复杂的重排序规则以及这些规则的具体实现方法。这里涉及到的所有内容后面都会有专门的章节介绍。

### JMM内存模型的底层实现

主要是通过内存屏障(memory barrier)禁止重排序的，即时编译器根据具体的底层体系架构，将这些内存屏障替换成具体的 CPU 指令。对于编译器而言，内存屏障将限制它所能做的重排序优化。而对于处理器而言，内存屏障将会导致缓存的刷新操作。比如，对于volatile，编译器将在volatile字段的读写操作前后各插入一些内存屏障。

## JMM与Java内存区域划分的区别与联系

- 区别：
    - JMM是抽象的，它用来描述一种规则，通过这个规则来控制各个变量的访问方式，围绕原子性，有序性，可见性等展开。
    - Java运行时内存的划分时具体的。
- 联系：
    - 都存在私有区域和共享区域。JMM中主内存属于共享区域，JMM的本地内存属于私有区域。

## 重排序与happens-before

### 重排序

JMM在基于`as-if-serial`语义的基础上，允许编译器和处理器对指令进行重排。

>  as-if-serial语义：不管怎么重排序，程序的执行结果不能改变。

> 计算机在执行程序时，为了提高性能，处理器和编译器常常会对指令进行重排序。

重排序需要满足以下两个条件：

- 在单线程环境下不能改变程序运行结果
- 存在数据依赖关系的指令不能进行重排序

> 流水线技术：指令1还没执行完，就可以开始执行指令2，这样大大地提高了效率。
>
> 流水线技术最害怕中断，而指令重排就是减少中断的一种技术。
>
> 指令重排虽然带来了乱序问题，但是对提高CPU处理性能非常有必要。（空间换时间的设计思想）

重排序的优点： 提高性能。

单线程重排序代码示例:

```java
int i = 0;  // 1
int j = 1;  // 2
int sum = i + k; // 3
```

上述例子中， 由于1，2是独立的语句，所以**单线程**可以按1->2->3的顺序执行，也可以按2->1->3的顺序执行。

#### 重排类型

- 编译器优化重排

  > 编译器在不改变单线程程序语义的前提下，可以重新安排语句执行重排

- 指令并行重排

  > 多线程处理器讲多条指令重叠执行。如果不存在数据依赖性(指令间)，处理器可以改变对应机器指令的执行顺序。

- 内存系统重排

  > 由于处理器使用缓存和存在读写缓冲区，使得加载（load）和存储（store）操作看上去可能是在乱序执行，因为三级缓存的存在，导致内存与缓存的数据同步存在时间差。

### happens-before

重排序不会影响单线程的执行结果，但在多线程条件下，重排序就有可能影响程序的执行结果。

多线程重排序代码示例：

```java
// 成员变量
int a = 0;
boolean flag = false; // 不用volatile修饰

public void writer() { // Thread-1
    a = 1; // step 1
    flag = true; // step 2
}

public void reader() { // Thread-2
    if (flag) { // step 3
        System.out.println(a); // step 4
    }
}

```

上述示例，假如线程Thread-1先执行writer()，然后线程Thread-2再执行reader()，线程Thread-2执行reader()不一定输出1。在writer()中，步骤1、2可能发生重排序。可能先执行步骤2，此时线程Thread-2如果执行到步骤3读取的flag为true输出的a的值就为0。

此时如果想要保证writer()方法在多线程条件下的有序性，有以下几个方法：

- `synchronized`关键字
- `Lock` 接口
- `volatile`关键字

除了这几个方法之外，JMM具备一些既定的有序性，不需要任何手段就能在某些情况下保证有序，这些保证有序的规则通常被称为**happens-before原则**。（JSR-133：Java Memory Model and Thread Specification）

> **如果操作A happens-before操作B，那么操作A在内存上所做的操作对操作B都是可见的，不管它们在不在一个线程。**

#### 1. 程序顺序规则

Each action in a thread happens before every subsequent action in that thread.

程序顺序规则是指，**一个线程内**的每一个操作，都happens-before于这个操作的后续操作。简单来讲就是程序对前面某个变量的修改对这个操作的后续操作一定是可见的。（对不同变量可能会发生指令重排，但不影响最终的一致性）。

```java
    private int i, j;
	/**
     * 测试happens-before 程序顺序性规则
     */
    @Test
    public void test_happens_before_order() {
        // 此处虽然i/j赋值可能会发生指令重排, 但理解为程序按序执行也没有问题,不影响后续求和操作的一致性
        i = 1;
        j = 2;
        int sum = i + j;
        System.out.println(sum);
    }
```



##### 程序顺序规则与指令重排



>顺序，指的是你可以用顺序的方式推演程序的执行，但是程序的执行不一定是完全顺序的。编译器保证结果一定 恒等于 顺序方式推演的结果。
>
>happens-before不代表时间上的先发生，只要程序的执行结果能够保证consistency就行。
>
>在上面例子中 i、j的赋值操作可能会发生重排，但能保证后续的sum求和的一致性。

#### 2. 监视器锁规则

An unlock on a monitor happens before every subsequent lock on that monitor.

这条规则是指对一个锁的解锁 Happens-Before 于后续对这个锁的加锁。这个规则也称为管程中的锁规则。

> 管程是一种通用的同步原语，在 Java 中指的就是 synchronized，synchronized 是 Java 里对管程的实现。
>
> 管程中的锁在 Java 里是隐式实现的，例如线程在进入synchronized同步块之前，会自动加锁，而在代码块执行完会自动释放锁，加锁以及释放锁都是编译器帮我们实现的。

```java
    /**
     * 测试 happens-before synchronized锁规则
     */
    @Test
    public void test_happens_before_synchronized() {
        // 0,111依次输出(t1, t2执行顺序根据时间片分配不同可能有变化, 但是根据synchronized锁规则, 两个线程不会同时输出0)
        new Thread(this::synWriter).start();
        new Thread(this::synWriter).start();
    }

    private void synWriter() {
        // 进入synchronized之前自动加锁
        synchronized (this) {
            System.out.println(x);
            if (x == 0) {
                x = 111;
            }
        }
        // 离开synchronized后自动解锁
    }
```



#### 3. 传递性

If an action a happens before an action b, and b happens before an action c, then a
happens before c.

如果 A Happens-Before B，且 B Happens-Before C，那么 A Happens-Before C。

#### 4. volatile变量规则

A write to a volatile field happens before every subsequent read of that volatile.

对一个 volatile 变量的写操作， Happens-Before 于后续对这个 volatile 变量的读操作。

- 使用普通成员变量

```java
	private boolean commonBool = false;
	/**
     * 测试多线程指令重排
     */
    @Test
    public void test_happens_before_reorder() {
        new Thread(this::writer).start();
        // 可能读到还没有被修改的值
        new Thread(this::reader).start(); // 输出0 或 1
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
```

- 使用volatile成员变量

```java
    private volatile boolean volatileBool = false;
    @Test
    public void test_happens_before_volatile() {
        new Thread(this::volatileWriter).start();
        // volatile规则 + 程序顺序规则 + 传递规则, 保证能读到写操作后的内容
        new Thread(this::volatileReader).start(); // 始终输出1
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
```



#### 5. start()规则

A call to start() on a thread happens before any actions in the started thread.

这条是关于线程启动，指主线程 A 启动子线程 B 后，子线程 B 能够看到主线程在启动子线程 B 前的操作。

```java
    /**
     * 测试 happens-before start()规则
     */
    @Test
    public void test_happen_before_start() {
        // 始终输出6
        Thread t2 = new Thread(() -> System.out.println(x));
        Thread t1 = new Thread(() -> {
            x = 6;
            // t1中调用t2的start(), 调用之前t1对成员变量的修改始终对t2可见
            t2.start();
        });
        t1.start();
    }
```



#### 6. join()原则

All actions in a thread happen before any other thread successfully returns from a
join() on that thread.

这条是关于线程等待，指主线程 A 等待子线程 B 完成（主线程 A 通过调用子线程 B 的 join() 方法实现），当子线程 B 完成后（主线程 A 中 join() 方法返回），主线程能够看到子线程的操作。当然所谓的“看到”，指的是对共享变量的操作。

```java
    /**
     * 测试 happens-before join()规则
     */
    @Test
    public void test_happens_before_join() {
        Thread t2 = new Thread(() -> x = 7);
        Thread t1 = new Thread(() -> {
            t2.start();
            try {
                System.out.println("before join, x = " + x);
                // t1中调用t2的join方法, t2中对成员变量x的操作对t1可见
                t2.join();
                System.out.println("after join, x= " + x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
    }
```



#### 7. interrupt()原则

对线程interrupt()方法的调用happens-before于被中断线程的代码检测到中断事件的发生，可以通过Thread.interrupted()方法检测到是否有中断发生。

#### 8. finalize()原则

一个对象的初始化完成(构造函数执行结束)happens-before于它的finalize()方法的开始。

## volatile

JMM中的happens-before原则中的**volatile变量规则**：对一个`volatile`变量域的写，必然happens-before于对这个`volatile`的读。

`volatile`关键字保证不管哪个线程对`volatile`修饰的变量进行了写操作，写入的值立即会更新至主内存；线程对该变量进行读操作时，JMM会把线程对应的本地内存置为无效，从主内存里读取刚写入的值。

`volatile`关键字可以保证可见性和有序性。

#### 为什么volatile无法保证原子性

volatile仅仅只能保证对单个变量的读/写操作的原子性。

比如，对于volatile自增，实际分为三步：
1. 读取内存中的volatile变量到本地
1. 增加变量的值
1. 将变量的值写会到内存，让其他线程可见
```text
mov    0xc(%r10),%r8d ; Load
inc    %r8d           ; Increment
mov    %r8d,0xc(%r10) ; Store
lock addl $0x0,(%rsp) ; StoreLoad Barrier
```

volatile写操作的最后一步是内存屏障，内存屏障的作用是使某些操作保持一定的顺序（确定哪些先执行哪些后执行，不能进行指令重排）。
> - LoadLoad屏障：对于这样的语句Load1; LoadLoad; Load2，在Load2及后续读取操作要读取的数据被访问前，保证Load1要读取的数据被读取完毕。
> - StoreStore屏障：对于这样的语句Store1; StoreStore; Store2，在Store2及后续写入操作执行前，保证Store1的写入操作对其它处理器可见。
> - LoadStore屏障：对于这样的语句Load1; LoadStore; Store2，在Store2及后续写入操作被刷出前，保证Load1要读取的数据被读取完毕。
> - StoreLoad屏障：对于这样的语句Store1; StoreLoad; Load2，在Load2及后续所有读取操作执行前，保证Store1的写入对所有处理器可见。它的开销是四种屏障中最大的（冲刷写缓冲器，清空无效化队列）。在大多数处理器的实现中，这个屏障是个万能屏障，兼具其它三种内存屏障的功能

内存屏障（memory barrier）和volatile什么关系？
> 上面的虚拟机指令里面有提到，如果你的字段是volatile，Java内存模型将在写操作后插入一个写屏障指令，在读操作前插入一个读屏障指令。这意味着如果你对一个volatile字段进行写操作，你必须知道：1、一旦你完成写入，任何访问这个字段的线程将会得到最新的值。2、在你写入前，会保证所有之前发生的事已经发生，并且任何更新过的数据值也是可见的，因为内存屏障会把之前的写入值都刷新到缓存。

最后，为什么volatile不能保证原子性？
> 从Load到store到内存屏障，一共4步，其中最后一步jvm让这个最新的变量的值在所有线程可见，也就是最后一步让所有的CPU内核都获得了最新的值，但中间的几步（从Load到Store）是不安全的，中间如果其他的CPU修改了值将会丢失。

#### volatile的应用

1. 状态量标记， 比如：

```Java
// 成员变量
int a = 0;
volatile boolean flag = false;

public void writer() { // Thread-1
    a = 1; // step 1
    flag = true; // step 2
}

public void reader() { // Thread-2
    if (flag) { // step 3
        System.out.println(a); // step 4
    }
}

```

`volatile`能保证修改的变量对所有线程可见。

1. 单例模式的实现，典型的双重检查锁定（DCL）

```Java
class Singleton {
    private volatile static Singleton instance = null; 
 
    public static Singleton getInstance() {
        if(instance == null) { // 第一次检查
            synchronized (Singleton.class) {
                if(instance == null) {  // 第二次检查
                    // 1.分配内存 2.初始化对象 3.设置instance指向1刚分配的地址
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

```

如果在声明变量时不使用`volatile`关键字，`instance = new Singleton()`有可能会被重排序：

```Java
instance = new Singleton();

// 可以分解为以下三个步骤
1 memory=allocate();// 分配内存 相当于c的malloc
2 ctorInstanc(memory) //初始化对象
3 s=memory //设置s指向刚分配的地址

// 上述三个步骤可能会被重排序为 1-3-2，也就是：
1 memory=allocate();// 分配内存 相当于c的malloc
3 s=memory //设置s指向刚分配的地址
2 ctorInstanc(memory) //初始化对象
```

如果发生了上述1->3->2的重排序，那么在DCL的第一次检查中，很有可能会读到已分配地址但是尚未完成初始化的`Singleton`对象。



## 参考

- [Java内存模型基础知识](http://concurrent.redspider.group/article/02/6.html)
- [重排序与happens-before](http://concurrent.redspider.group/article/02/7.html)
- [volatile](http://concurrent.redspider.group/article/02/8.html)
- [面试官最爱的volatile关键字](https://juejin.im/post/5a2b53b7f265da432a7b821c)
- [并发编程的锁机制：synchronized和lock](https://juejin.im/post/5a43ad786fb9a0450909cb5f) 
- [JSR-133](https://download.oracle.com/otndocs/jcp/memory_model-1.0-pfd-spec-oth-JSpec/)
- [为什么volatile不能保证原子性而Atomic可以？](https://www.cnblogs.com/mainz/p/3556430.html)