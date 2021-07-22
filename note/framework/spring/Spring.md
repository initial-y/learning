# Spring 

## Spring IOC

### 控制反转（IOC）

在业务代码开发过程中, 通常由开发者主动声明实现类，通过new创建对象的方式获取对象，这种方式获取对象的控制权在我们自己。

```java
Demo demo = new Demo();
```

但在使用Spring的过程中，使用`BeanFactory`获取对象的方式就将获取对象的控制权交给了别人。这种将获取对象控制权交给别人的**思想**， 就叫做**控制反转（Inverse of Control)**。

```java
Demo demo = (Demo) BeanFactory.getBean("demo");
```



`BeanFactory`根据指定的`beanName`去获取对象的过程，就叫做**依赖查找（Dependency Lookup, DL）**。

### 反射(Reflection)

Java 的反射机制是指在运行状态中，对于任意一个类都能够知道这个类所有的属性和方法； 并且对于任意一个对象，都能够调用它的任意一个方法；这种动态获取信息以及动态调用对象方法的功能成为Java语言的反射机制。

反射是`Spring`实现控制反转的重要机制。

#### Class对象

每个类都有一个Class对象，每当编译一个新类就产生一个Class对象。比如：创建一个`ReflectionDemo`类，JVM就会创建一个`ReflectionDemo`类对应的Class对象，该Class对象保存了`ReflectionDemo`类相关的类型信息。

Class类对象的作用是运行时提供或获取某个对象的类型信息。

##### RTTI与RRTI

Java是如何让我们在运行时识别对象和类的信息？

- RRTI：RRTI假定我们在编译器就知道所有的对象类型。
- RTTI，**Run-Time Type Identification**，在运行时识别一个对象的类型和类的信息。

#### 反射的基本使用

##### 获取Class对象

###### Class.forName静态方法

```java
Class clz = Class.forName("base.reflection.ReflectionDemo");
```

###### 类的.class方法

```java
Class clz = ReflectionDemo.class;
```

###### 实例对象的 getClass() 方法

```java
ReflectionDemo demo = new ReflectionDemo();
Class clz = demo.getClass();
```

##### 反射获取类信息

###### 创造对象

1. 通过Class的`newInstance()`方法

```java
Class clz = Class.forName("base.reflection.ReflectionDemo");
ReflectionDemo demo = (ReflectionDemo) clz.newInstance();
```

2. 通过Constructor的`newInstance()`方法

```java
Class clz = Class.forName("base.reflection.ReflectionDemo");
Constructor constructor = clz.getConstructor();
ReflectionDemo demo1 = (ReflectionDemo) constructor.newInstance();
```

###### 获取构造函数

![反射获取构造函数](D:/Code/IdeaProjects/learning/note/framework/spring/imgs/%E5%8F%8D%E5%B0%84%E8%8E%B7%E5%8F%96%E6%9E%84%E9%80%A0%E5%99%A8.png)

1. 获取所有public的构造方法： `getConstructors()`

```java
Class clz = Class.forName("base.reflection.ReflectionDemo");
Constructor[] constructors = clz.getConstructors();
```

2. 获取所有的构造方法：`getDeclaredConstructors()`

```java
// 所有 public + protect + private
Class clz = Class.forName("base.reflection.ReflectionDemo");
Constructor[] declaredConstructors = clz.getDeclaredConstructors();
```

3. 获取指定参数类型且是public的构造器：`getConstructor(Class<?>... parameterTypes)`

```java
Class clz = Class.forName("base.reflection.ReflectionDemo");
Constructor paramConstructor = clz.getConstructor(String.class);
```

4. 获取指定参数类型public或private的构造器：`getDeclaredConstructor(Class<?>... parameterTypes)`

```java
// public/private，protect不行
Class clz = Class.forName("base.reflection.ReflectionDemo");
Constructor declaredParamConstructor = clz.getDeclaredConstructor(Integer.class);
```

###### 获取方法

![反射获取方法](D:/Code/IdeaProjects/learning/note/framework/spring/imgs/%E5%8F%8D%E5%B0%84%E8%8E%B7%E5%8F%96%E6%96%B9%E6%B3%95.png)

1. 获得类的public类型的方法：`getMethods()`， 包括继承自Object类的方法

   ```java
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Method[] pubMethods = clz.getMethods();
   System.out.println(pubMethods.length);
   ```

2. 获得本类的所有方法：`getDeclaredMethods()`， 不包括Object类的方法

   ```java
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Method[] clzMethods = clz.getDeclaredMethods();
   ```

3. 指定参数获取类的特定方法：`getDeclaredMethod(String name, Class<?>... parameterTypes)`

   ```java
   // private 不行
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Method declaredMethod = clz.getDeclaredMethod("print", int.class);
   declaredMethod.invoke(clz.newInstance(), 1);
   ```

###### 获取成员变量

![反射获取成员变量](D:/Code/IdeaProjects/learning/note/framework/spring/imgs/%E5%8F%8D%E5%B0%84%E8%8E%B7%E5%8F%96%E6%88%90%E5%91%98%E5%8F%98%E9%87%8F.png)

1. 获得类的public属性：`getFields()`

   ```java
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Field[] pubFields = clz.getFields();
   ```

2. 获得类的所有属性：`getDeclaredFiled()`

   ```java
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Field[] fields = clz.getDeclaredFields();
   ```

3. 根据变量名获得一个public的属性：`getField(String name)`

   ```java
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Field pubField = clz.getField("num");
   ```

4. 根据变量名获得成员变量：`getDeclaredFiled(String name)`

   ```java
   // 不限制访问权限
   Class clz = Class.forName("base.reflection.ReflectionDemo");
   Field declaredField = clz.getDeclaredField("param");
   ```

#### 反射原理

![反射调用invoke方法时序图](D:/Code/IdeaProjects/learning/note/framework/spring/imgs/%E5%8F%8D%E5%B0%84invoke%E6%96%B9%E6%B3%95%E6%89%A7%E8%A1%8C%E6%97%B6%E5%BA%8F%E5%9B%BE.png)

```java
	// 测试类的测试方法
    @Test
    public void test_reflection_print_invoke_method() throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Method declaredMethod = clz.getDeclaredMethod("printNum", int.class);
        declaredMethod.invoke(clz.newInstance(), 111);
    }

	// ReflectionDemo类的printNum方法打印调用链
    protected void printNum(int num) {
        //打印堆栈信息
        new Exception("#" + num).printStackTrace();
        System.out.println("invoke target method");
    }
```

输出

```text
invoke target method
java.lang.Exception: #111
	at base.reflection.ReflectionDemo.printNum(ReflectionDemo.java:23)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at base.reflection.ReflectionDemoTest.test_reflection_print_invoke_method(ReflectionDemoTest.java:114)
	····· 省略测试类调用链路
```

先来看`Method.invoke()`源码

```java
   	// Method.invoke
	@CallerSensitive
    public Object invoke(Object obj, Object... args)
        throws IllegalAccessException, IllegalArgumentException,
           InvocationTargetException
    {
        if (!override) {
            if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
                Class<?> caller = Reflection.getCallerClass();
                checkAccess(caller, clazz, obj, modifiers);
            }
        }
        // MethodAccessor接口有三个实现类：DelegatingMethodAccessorImpl、MethodAccessorImpl、NativeMethodAccessorImpl
        MethodAccessor ma = methodAccessor;             // read volatile
        if (ma == null) {
            ma = acquireMethodAccessor();
        }
        return ma.invoke(obj, args);
    }
    
	// Method.invoke -> Method.aquireMethodAccessor
    private MethodAccessor acquireMethodAccessor() {
        // First check to see if one has been created yet, and take it
        // if so
        MethodAccessor tmp = null;
        if (root != null) tmp = root.getMethodAccessor();
        if (tmp != null) {
            methodAccessor = tmp;
        } else {
            // Otherwise fabricate one and propagate it up to the root
            tmp = reflectionFactory.newMethodAccessor(this);
            setMethodAccessor(tmp);
        }

        return tmp;
    }

	// Method.acquireMethodAccessor -> ReflectionFactory.newMethodAccessor
    public MethodAccessor newMethodAccessor(Method var1) {
        checkInitted();
        if (noInflation && !ReflectUtil.isVMAnonymousClass(var1.getDeclaringClass())) {
            return (new MethodAccessorGenerator()).generateMethod(var1.getDeclaringClass(), var1.getName(), var1.getParameterTypes(), var1.getReturnType(), var1.getExceptionTypes(), var1.getModifiers());
        } else {
            NativeMethodAccessorImpl var2 = new NativeMethodAccessorImpl(var1);
            // DelegatingMethodAccessorImpl extends MethodAccessorImpl
            DelegatingMethodAccessorImpl var3 = new DelegatingMethodAccessorImpl(var2);
            var2.setParent(var3);
            return var3;
        }
    }
	// ReflectionFactory.newMethodAccessor -> NativeMethodAccessorImpl构造方法
    NativeMethodAccessorImpl(Method var1) {
        this.method = var1;
    }
// ReflectionFactory.newMethodAccessor -> DelegatingMethodAccessorImpl构造方法
class DelegatingMethodAccessorImpl extends MethodAccessorImpl {
    private MethodAccessorImpl delegate;

    DelegatingMethodAccessorImpl(MethodAccessorImpl var1) {
        this.setDelegate(var1);
    }

    public Object invoke(Object var1, Object[] var2) throws IllegalArgumentException, InvocationTargetException {
        // this.delegate = NativeMethodAccessorImpl
        return this.delegate.invoke(var1, var2);
    }

    void setDelegate(MethodAccessorImpl var1) {
        this.delegate = var1;
    }
}
	// DelegatingMethodAccessorImpl -> NativeMethodAccessorImpl.invoke()
    public Object invoke(Object var1, Object[] var2) throws IllegalArgumentException, InvocationTargetException {
        if (++this.numInvocations > ReflectionFactory.inflationThreshold() && !ReflectUtil.isVMAnonymousClass(this.method.getDeclaringClass())) {
            MethodAccessorImpl var3 = (MethodAccessorImpl)(new MethodAccessorGenerator()).generateMethod(this.method.getDeclaringClass(), this.method.getName(), this.method.getParameterTypes(), this.method.getReturnType(), this.method.getExceptionTypes(), this.method.getModifiers());
            this.parent.setDelegate(var3);
        }
		// 就是它！Method的invoke方法，是由本地方法invoke0决定的
        return invoke0(this.method, var1, var2);
    }
```

#### 反射应用

##### JDBC数据库连接

加载驱动，获得数据库连接

```java
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
```

##### Spring框架

Spring 通过 XML 配置模式装载 Bean，也是反射的一个典型例子。

通过Spring框架使用Bean， 不用每次都去new实例了，并且可以修改配置文件，比较灵活。

**装载过程：**

- 将程序内XML 配置文件加载入内存中
- Java类解析xml里面的内容，得到相关字节码信息
- 使用反射机制，得到Class实例
- 动态配置实例的属性，使用

#### 反射存在的问题

##### 安全问题

我们知道单例模式的设计过程中，会强调**将构造器设计为私有**，因为这样可以防止从外部构造对象。但是反射可以获取类中的域、方法、构造器，**修改访问权限**。所以这样并不一定是安全的。

```java
    // 测试类
	@Test
    public void test_reflection_modify_access_permission() throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Constructor constructor = clz.getDeclaredConstructor(Integer.class);
        // 绕过Java语言访问检查
        constructor.setAccessible(true);
        // 打印 private constructor， num = 111
        constructor.newInstance(111);
    }
	// ReflectionDemo类私有构造方法
    private ReflectionDemo(Integer pram) {
        System.out.println("private constructor， num = " + num);
    }
```



##### 性能问题

反射的性能并不好，原因主要是编译器没法对反射相关的代码做优化。



## Spring AOP

### AOP

AOP（Aspect Orient Programming），面向切面编程。AOP是一种面向对象的补充，用于处理系统中分布于各个模块的横切关注点，比如事务管理、日志、缓存等等。

AOP实现的关键在于AOP框架自动创建的AOP代理，AOP代理又分为静态代理和动态代理。静态代理的代表是AspectJ，动态代理的代表是Spring AOP。

### Spring AOP

Spring AOP中的动态代理有**JDK动态代理**和**CGLIB动态代理**两种方式。

#### JDK动态代理

JDK动态代理通过反射来接收被代理的类，并且**要求被代理的类必须实现一个接口**。

JDK动态代理的核心是`InvocationHandler`接口和`Proxy`类。

如果目标类没有实现接口，那么Spring AOP会选择使用CGLIB来动态代理目标类。

##### 代理模式

![代理模式](imgs/代理模式.png)

在代理模式中，要求：

- 目标对象和代理对象都共同实现的了同一个接口。
- 目标对象中存在的方法在代理对象中也同样存在。

代理模式分为两种：

- 静态代理：代理类在编译器就确定好。 Java 编译完成后代理类是一个实际的 class 文件。
- 动态代理：代理类是在运行时生成的。Java 编译完之后并没有实际的 class 文件，而是在运行时动态生成的类字节码，并加载到JVM中。

Java如何实现动态代理：

1. 定义一个接口及其实现类

   ```java
   /**
    * 接口类
    * @ClassName DynamicProxyService
    * @Descripiton
    * @Author initial_yang
    * @Date 2020/2/21
    */
   public interface DynamicProxyService {
       void testDynamic();
   }
   
   /**
    * 实现类
    * @ClassName DynamicProxyServiceImpl
    * @Descripiton
    * @Author initial_yang
    * @Date 2020/2/21
    */
   public class DynamicProxyServiceImpl implements DynamicProxyService {
       @Override
       public void testDynamic() {
           System.out.println("JDK动态代理，目标类的方法实现，在这前后实现切面");
       }
   }
   ```

2. 通过实现`InvocationHandler`接口来自定义自己的`InvocationHandler`，指定运行时将生成的代理类需要完成的具体任务(添加切面)

   ```java
   /**
    * @ClassName DynamicProxyInvocationHandler
    * @Descripiton
    * @Author initial_yang
    * @Date 2020/2/21
    */
   public class DynamicProxyInvocationHandler implements InvocationHandler {
   
       /**
        * 目标对象
        */
       private Object target;
   
       public DynamicProxyInvocationHandler(Object target) {
           this.target = target;
       }
   
       /**
        * invoke方法
        * @description 在invoke方法中加入切面逻辑
        * @param proxy
        * @param method
        * @param args
        * @return
        * @throws Throwable
        */
       @Override
       public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
   
           System.out.println("切面--代理方法执行前");
           // 通过反射执行目标类的方法
           Object result = method.invoke(target, args);
           System.out.println("切面--代理方法执行后");
           return result;
       }
   }
   ```

   3. 生成代理对象

      ```java
      /**
       * @ClassName DynamicProxyTest
       * @Descripiton
       * @Author initial_yang
       * @Date 2020/2/21
       */
      public class DynamicProxyTest {
      
          @Test
          public void testGetProxyClass() throws NoSuchMethodException, IllegalAccessException,
                  InvocationTargetException, InstantiationException {
              // 1. 获取动态代理类
              Class proxyClass = Proxy.getProxyClass(DynamicProxyService.class.getClassLoader(), DynamicProxyService.class);
              // 2. 获得代理类的构造函数，并传入参数类型InvocationHandler.class
              Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
              // 3. 通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
              DynamicProxyService dynamicProxyService = (DynamicProxyService)
                      constructor.newInstance(new DynamicProxyInvocationHandler(new DynamicProxyServiceImpl()));
              // 4. 通过代理对象调用目标方法
              dynamicProxyService.testDynamic();
              System.out.println(proxyClass);
          }
          
              @Test
          public void testJDKDynamicProxy() {
      
      //        DynamicProxyServiceImpl subClass = new DynamicProxyServiceImpl();
      //        DynamicProxyInvocationHandler handler = new DynamicProxyInvocationHandler(subClass);
      //        DynamicProxyService proxyService = (DynamicProxyService) Proxy.newProxyInstance(subClass.getClass().getClassLoader(),
      //                subClass.getClass().getInterfaces(), handler);
              DynamicProxyService dynamicProxyService = (DynamicProxyService) Proxy.newProxyInstance(DynamicProxyService.class.getClassLoader(),
                      DynamicProxyServiceImpl.class.getInterfaces(), new DynamicProxyInvocationHandler(new DynamicProxyServiceImpl()));
              dynamicProxyService.testDynamic();
              System.out.println(dynamicProxyService.getClass());
      
          }
      
      }
      ```

      

#### CGLIB代理

CGLIB（Code Generation Library），是一个代码生成的类库，可以在运行时动态的生成某个类的子类。

注意，CGLIB是通过继承的方式做的动态代理，因此如果某个类被标记为`final`，那么它是无法使用CGLIB做动态代理的。

## 参考

- [谈谈Java反射：从入门到实践，再到原理](https://juejin.im/post/5de3242e6fb9a071886675d7#heading-24)
- [JDK动态代理以及Spring AOP使用介绍](https://www.jianshu.com/p/fa339e474c7a)



