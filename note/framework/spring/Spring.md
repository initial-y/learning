# Spring 

## Spring IOC

### 控制反转（IOC）

在业务代码开发过程中, 通常由开发者主动声明实现类，通过new创建对象的方式获取对象，这种方式获取对象的控制权在我们自己。

```java
Demo demo = new Demo();
```

但在使用Spring的过程中，使用`BeanFactory`获取对象的方式就将获取对象的控制权交给了别人。这种将获取对象控制权交给别人的**思想**， 就叫做**控制反转（Inverse of Control)**。

#### 依赖查找与依赖注入

##### 依赖查找(DL)

```java
// 根据id查找
Demo demo = (Demo) BeanFactory.getBean("demo");
```

`BeanFactory`根据指定的`beanName`去获取对象的过程，就叫做**依赖查找（Dependency Lookup, DL）**。

依赖查找获取了类的实例，如果这个类不需要使用内部的属性的话，到这一步已经可以了。

###### ofType

xml配置:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="spring.ioc.dao.impl.IocDaoImpl"/>
    <bean class="spring.ioc.dao.impl.IocDaoOneImpl"/>
    <bean class="spring.ioc.dao.impl.IocDaoTwoImpl"/>

</beans>
```

代码:

```java
public static void main(String[] args) {
    // 使用ApplicationContext批量获取
    ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/dl-bytype.xml");
    Map<String, IocDao> beans = ctx.getBeansOfType(IocDao.class);
    beans.forEach((beanName, bean) -> {
        System.out.println(beanName + " : " + bean.toString());
    });
}
```

##### 依赖注入(DI)

依赖注入是一种具体的编程技巧。

依赖注入不通过New关键字在类的内部创建依赖类对象，而将依赖类的对象在外部创建好之后，通过构造函数、函数参数等方式传递（注入）给类使用。

###### 依赖查找与依赖注入的区别

> 依赖查找获取了类的实例，如果这个类不需要使用内部的属性的话，到这一步已经可以了。依赖注入是为了给类的实例对象的字段赋值，因为描述一个实体除了方法还有字段。DI和DL都是IoC在创建和管理实例的一个过程的两个方面。 依赖注入和依赖查找本质都是通过反射来实现的。
>
> - 作用目标不同
>   - 依赖注入的作用目标通常是类成员
>   - 依赖查找的作用目标可以是方法体内，也可以是方法体外
> - 实现方式不同
>   - 依赖注入通常借助一个上下文被动的接收
>   - 依赖查找通常主动使用上下文搜索

#### BeanFactory与ApplicationContext

##### BeanFactory

`BeanFactory` 接口提供了一个**抽象的配置和对象的管理机制**;

##### ApplicationContext

`ApplicationContext` 是 `BeanFactory` 的子接口，它简化了与 AOP 的整合、消息机制、事件机制，以及对 Web 环境的扩展（ `WebApplicationContext` 等），`BeanFactory` 是没有这些扩展的。

`ApplicationContext` 主要扩展了以下功能：

- AOP 的支持（ `AnnotationAwareAspectJAutoProxyCreator` 作用于 Bean 的初始化之后 ）
- 配置元信息（ `BeanDefinition` 、`Environment` 、注解等 ）
- 资源管理（ `Resource` 抽象 ）
- 事件驱动机制（ `ApplicationEvent` 、`ApplicationListener` ）
- 消息与国际化（ `LocaleResolver` ）
- `Environment` 抽象（ SpringFramework 3.1 以后）

关于ApplicationContext, Spring官方的概述:

> The `org.springframework.beans` and `org.springframework.context` packages are the basis for Spring Framework’s IoC container. The [`BeanFactory`](https://link.juejin.cn/?target=https%3A%2F%2Fdocs.spring.io%2Fspring-framework%2Fdocs%2F5.2.x%2Fjavadoc-api%2Forg%2Fspringframework%2Fbeans%2Ffactory%2FBeanFactory.html) interface provides an advanced configuration mechanism capable of managing any type of object. [`ApplicationContext`](https://link.juejin.cn/?target=https%3A%2F%2Fdocs.spring.io%2Fspring-framework%2Fdocs%2F5.2.x%2Fjavadoc-api%2Forg%2Fspringframework%2Fcontext%2FApplicationContext.html) is a sub-interface of `BeanFactory`. It adds:
>
> - Easier integration with Spring’s AOP features
> - Message resource handling (for use in internationalization)
> - Event publication
> - Application-layer specific contexts such as the `WebApplicationContext` for use in web applications.
>
> `org.springframework.beans` 和 `org.springframework.context` 包是 SpringFramework 的 IOC 容器的基础。`BeanFactory` 接口提供了一种高级配置机制，能够管理任何类型的对象。`ApplicationContext` 是 `BeanFactory` 的子接口。它增加了：
>
> - 与 SpringFramework 的 AOP 功能轻松集成
> - 消息资源处理（用于国际化）
> - 事件发布
> - 应用层特定的上下文，例如 Web 应用程序中使用的 `WebApplicationContext`

##### BeanFactory与ApplicationContext对比

| Feature                                                      | BeanFactory | ApplicationContext |
| ------------------------------------------------------------ | ----------- | ------------------ |
| Bean instantiation/wiring —— Bean的实例化和属性注入          | 支持        | 支持               |
| Integrated lifecycle management —— 生命周期管理              | 不支持      | 支持               |
| Automatic `BeanPostProcessor` registration —— Bean后置处理器的支持 | 不支持      | 支持               |
| Automatic `BeanFactoryPostProcessor` registration —— BeanFactory后置处理器的支持 | 不支持      | 支持               |
| Convenient `MessageSource` access (for internalization) —— 消息转换服务（国际化） | 不支持      | 支持               |
| Built-in `ApplicationEvent` publication mechanism —— 事件发布机制（事件驱动） | 不支持      | 支持               |

### IOC基础

#### 注解驱动IOC与组件扫描

##### 注解驱动IOC

```java
// id = "aaa"
@Bean(name = "aaa") // 4.3.3之后可以直接写value
public Person person() {
    return new Person();
}
```

> 上述代码意为: **向 IOC 容器注册一个类型为 Person ，id 为 person 的 Bean** 。**方法的返回值代表注册的类型，方法名代表 Bean 的 id** 。当然，也可以直接在 `@Bean` 注解上显式的声明 Bean 的 id ，只不过在注解驱动的范畴里，它不叫 id 而是叫 **name**

##### 组件扫描

###### @Component

```java
// 在类上标注 @Component 注解，即代表该类会被注册到 IOC 容器中作为一个 Bean 
@Component(value="person")
public class Person {
    
}
```

上面的代码等同于xml:

```xml
// id对应注解中的value
<bean id="person" class="spring.ioc.bean.Person"/>
```

指定名称是使用@Component的value属性, 如果不指定 Bean 的名称，它的默认规则是 **“类名的首字母小写”**

###### @componentScan

> 只声明了组件，咱在写配置类时如果还是只写 `@Configuration` 注解，随后启动 IOC 容器，那它是感知不到有 `@Component` 存在的，一定会报 `NoSuchBeanDefinitionException` 。
>
> 为了解决这个问题，咱需要引入一个新的注解：`@ComponentScan` 

在配置类上额外标注一个 `@ComponentScan` ，并指定要扫描的路径，它就可以**扫描指定路径包及子包下的所有 `@Component` 组件**：

```java
@Configuration
@ComponentScan("spring.ioc.bean")
public class ComponentScanConfiguration {
    
}
```

如果不指定扫描路径，则**默认扫描本类所在包及子包下的所有 `@Component` 组件**

另外, 如果不声明@ComponentScan也可以坐到组件扫描

```java
ApplicationContext ctx = new AnnotationConfigApplicationContext("spring.ioc.bean");
```

#### 依赖注入

##### 属性注入

###### xml方式

```xml
<bean id="person" class="spring.ioc.bean.Person">
    <property name="name" value="person"/>
    <property name="age" value="1"/>
</bean>
```

###### 注解方式

```java
@Bean
public Person person() {
    Person person = new Person();
    person.setName("person");
    person.setAge(1);
    return person;
}
```

##### 构造器注入

###### 构造方法方式

```java
public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
}
```

###### xml方式

```xml
    <bean id="person" class="spring.ioc.bean.Person">
        <constructor-arg index="0" value=""/>
        <constructor-arg index="1" value=""/>
    </bean>
```

##### 注解式属性注入

```java
public class Person {

    @Value("test")
    private String name;

    @Value("1")
    private Integer age;

}
```

###### 外部配置文件引入@PropertySource

```java
@Configuration
// or @PropertySources
@PropertySource(value = "classpath:xxx.properties")
public class IocConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
		
```

使用@PropertySource之后, @Value使用占位符就可以表示注入的属性。

```java
@Value("${xxx.name}")
private String name;
```

##### 自动注入-@Autowired

###### @Autowired

> 在 Bean 中直接在 **属性 / setter 方法** 上标注 `@Autowired` 注解，IOC 容器会**按照属性对应的类型，从容器中找对应类型的 Bean 赋值到对应的属性**上，实现自动注入。
>
> `@Autowired` 不仅可以用在普通 Bean 的属性上，在配置类中，注册 `@Bean` 时也可以标注:
>
> ```java
>     @Bean
>     @Autowired
>     public Dog dog() {
>         return new Dog();
>     }
> ```
>
> 

@Autowired注入的原理逻辑:

> **先拿属性对应的类型，去 IOC 容器中找 Bean ，如果找到了一个，直接返回；如果找到多个类型一样的 Bean ， 把属性名拿过去，跟这些 Bean 的 id 逐个对比，如果有一个相同的，直接返回；如果没有任何相同的 id 与要注入的属性名相同，则会抛出 `NoUniqueBeanDefinitionException` 异常。**



###### @Qualifier

> `@Qualifier` 注解的使用目标是要注入的 Bean ，它配合 `@Autowired` 使用，可以显式的指定要注入哪一个 Bean ,
>
> 在存在多个相同类型的Bean的情况, `@Qualifier`可以显示指定要注入的Bean

###### @Primary

> `@Primary` 注解的使用目标是被注入的 Bean ，在一个应用中，一个类型的 Bean 注册只能有一个，它配合 `@Bean` 使用，可以指定默认注入的 Bean
>
> 如果有多个相同类型的 Bean 同时注册到 IOC 容器中，使用 “根据类型注入” 的注解时会注入标注 `@Primary` 注解的 bean
>
> ```java
>     @Bean
>     @Primary
>     public Person master() {
>         Person master = new Person();
>         master.setName("master");
>         return master;
>     }
> ```
>
> 

##### 自动注入-@Resource

###### @Resource

> `@Resource` 也是用来属性注入的注解，它与 `@Autowired` 的不同之处在于：**`@Autowired` 是按照类型注入，`@Resource` 是直接按照属性名 / Bean的名称注入**。

##### 自动注入-@Inject

> JSR330 也提出了跟 `@Autowired` 一样的策略，它也是**按照类型注入**。不过想要用 JSR330 的规范，需要额外导入一个依赖：
>
> ```xml
> <!-- jsr330 -->
> <dependency>
>     <groupId>javax.inject</groupId>
>     <artifactId>javax.inject</artifactId>
>     <version>1</version>
> </dependency>
> ```

##### 自动注入对比

| 注解       | 注入方式     | 是否支持@Primary | 来源                       | Bean不存在时处理                   |
| ---------- | ------------ | ---------------- | -------------------------- | ---------------------------------- |
| @Autowired | 根据类型注入 | 是               | SpringFramework原生注解    | 可指定required=false来避免注入失败 |
| @Resource  | 根据名称注入 | 是               | JSR250规范                 | 容器中不存在指定Bean会抛出异常     |
| @Inject    | 根据类型注入 | 是               | JSR330规范 ( 需要导jar包 ) | 容器中不存在指定Bean会抛出异常     |

#### Bean的类型及作用域

##### Bean的类型

###### 普通Bean

```java
@Component
public class Dog {

}

// 或者@Bean创建
@Bean
public Dog dog() {
    return new Dog();
}
// 或者通过xml配置创建

```

###### 工厂Bean

> `FactoryBean` ：创建对象的工厂 Bean ，可以使用它来直接创建一些初始化流程比较复杂的对象
>
> **`FactoryBean` 本身的加载是伴随 IOC 容器的初始化时机一起的**。
>
> **`FactoryBean` 生产 Bean 的机制是延迟生产**。
>
> **`FactoryBean` 默认生成的 Bean 确实是单实例的**。

##### Bean的作用域

| 作用域类型    | 概述                                         |
| ------------- | -------------------------------------------- |
| **singleton** | 一个 IOC 容器中只有一个【默认值】            |
| **prototype** | 每次获取创建一个                             |
| request       | 一次请求创建一个（仅Web应用可用）            |
| session       | 一个会话创建一个（仅Web应用可用）            |
| application   | 一个 Web 应用创建一个（仅Web应用可用）       |
| websocket     | 一个 WebSocket 会话创建一个（仅Web应用可用） |

###### singleton

![singleton](imgs/singleton.png)

> SpringFramework 中默认所有的 Bean 都是单实例的，即：**一个 IOC 容器中只有一个**

###### prototype

![prototype](imgs/prototype.png)

> prototype: 每次对原型 Bean **提出请求**时，都会创建一个新的 Bean 实例。
>
> >  提出请求: 包括任何依赖查找、依赖注入的动作，都算做一次 ”提出请求“ 。
>
> 如果连续 `getBean()` 两次，那就应该创建两个不同的 Bean 实例；向两个不同的 Bean 中注入两次，也应该注入两个不同的 Bean 实例。

###### web相关作用域: request /session/application/websocket

- request ：请求Bean，每次客户端向 Web 应用服务器发起一次请求，Web 服务器接收到请求后，由 SpringFramework 生成一个 Bean ，直到请求结束
- session ：会话Bean，每个客户端在与 Web 应用服务器发起会话后，SpringFramework 会为之生成一个 Bean ，直到会话过期
- application ：应用Bean，每个 Web 应用在启动时，SpringFramework 会生成一个 Bean ，直到应用停止（有的也叫 global-session ）
- websocket ：WebSocket Bean ，每个客户端在与 Web 应用服务器建立 WebSocket 长连接时，SpringFramework 会为之生成一个 Bean ，直到断开连接

#### Bean的实例化方式

##### 普通Bean实例化

通过`<bean>` 标签、`@Bean` 注解创建Bean的方式, 都是普通实例化

##### 借助FactoryBean

```java
public class BallFactoryBean implements FactoryBean<Ball> {
    
    @Override
    public Ball getObject() {
        return new Ball();
    }
    
    @Override
    public Class<Ball> getObjectType() {
        return Ball.class;
    }
}
```

##### 借助静态工厂

注意, 静态工厂本身不会被注册到IOC容器中

```java
public class CarStaticFactory {
    
    // 静态方法
    public static Car getCar() {
        return new Car();
    }
}
```

##### 借助实例工厂

```java
public class CarInstanceFactory {
    
    public Car getCar() {
        return new Car();
    }
}
```

#### Bean的生命周期

> 一个对象从被创建，到被垃圾回收，可以宏观的划分为 5 个阶段：
>
> - 创建 / 实例化阶段：此时会调用类的构造方法，产生一个新的对象
> - **初始化阶段**：此时对象已经创建好，但还没有被正式使用，可能这里面需要做一些额外的操作（如预初始化数据库的连接池）
> - 运行使用期：此时对象已经完全初始化好，程序正常运行，对象被使用
> - **销毁阶段**：此时对象准备被销毁，已不再使用，需要预先的把自身占用的资源等处理好（如关闭、释放数据库连接）
> - 回收阶段：此时对象已经完全没有被引用了，被垃圾回收器回收
>
> 其中，初始化和销毁阶段是能被Spring干预的阶段

##### init-method与destory-method

###### xml配置

```xml
    <bean class="spring.ioc.bean.Cat" 
          init-method="init" destroy-method="destroy"></bean>
```

###### 注解配置

```java
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Dog dog() {
        Dog dog = new Dog();
        dog.setName("wangwang");
        return dog;
    }
```

###### 方法要求

对于init与destroy方法：

> - 方法访问权限无限制要求（ SpringFramework 底层会反射调用的）
> - 方法**无参数**（如果真的设置了参数，SpringFramework 也不知道传什么进去）
> - 方法**无返回值**（返回给 SpringFramework 也没有意义）
> - 可以抛出异常（异常不由自己处理，交予 SpringFramework 可以打断 Bean 的初始化 / 销毁步骤）

##### JSR250规范

> JSR250 规范中除了有 `@Resource` 这样的自动注入注解，还有负责生命周期的注解，包括 **`@PostConstruct`** 、**`@PreDestroy`** 两个注解，分别对应 `init-method` 和 `destroy-method` 。
>
> **JSR250 规范的执行优先级高于 init / destroy**。

##### InitializingBean&DisposableBean

两个接口，**afterPropertiesSet()**与**destory()**是两个关于生命周期的接口，能够实现初始化与销毁动作。

```java
@Component
public class Pen implements InitializingBean, DisposableBean {
    
    private Integer ink;
    
    // 等同于init-method
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("钢笔中已加满墨水。。。");
        this.ink = 100;
    }
    
    // 等同于destroy
    @Override
    public void destroy() throws Exception {
        System.out.println("钢笔中的墨水都放干净了。。。");
        this.ink = 0;
    }
    
    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}

```

##### 三种生命周期对比

执行顺序：

> **`@PostConstruct` → `InitializingBean` → `init-method`** 

对比图：

| 方式       | init-method & destroy-method              | @PostConstruct & @PreDestroy    | InitializingBean & DisposableBean |
| ---------- | ----------------------------------------- | ------------------------------- | --------------------------------- |
| 执行顺序   | 最后                                      | 最先                            | 中间                              |
| 组件耦合度 | 无侵入（只在 `<bean>` 和 `@Bean` 中使用） | 与 JSR 规范耦合                 | 与 SpringFramework 耦合           |
| 容器支持   | xml 、注解原生支持                        | 注解原生支持，xml需开启注解驱动 | xml 、注解原生支持                |
| 单实例Bean | √                                         | √                               | √                                 |
| 原型Bean   | 只支持 init-method，**不支持destroy**     | √                               | √                                 |



### IOC进阶

#### 注入

##### 回调注入

回调注入的核心是`Aware`接口

| 接口名                         | 用途                                                         |
| ------------------------------ | ------------------------------------------------------------ |
| BeanFactoryAware               | 回调注入 BeanFactory                                         |
| ApplicationContextAware        | 回调注入 ApplicationContext（与上面不同，后续 IOC 高级讲解） |
| EnvironmentAware               | 回调注入 Environment（后续IOC高级讲解）                      |
| ApplicationEventPublisherAware | 回调注入事件发布器                                           |
| ResourceLoaderAware            | 回调注入资源加载器（xml驱动可用）                            |
| BeanClassLoaderAware           | 回调注入加载当前 Bean 的 ClassLoader                         |
| BeanNameAware                  | 回调注入当前 Bean 的名称                                     |

##### 延迟注入

`ObjectProvider` 可应用于延迟注入。

#### IOC容器

##### BeanFactory



##### ApplicationContext



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



