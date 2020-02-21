package spring.aop.jdkproxy;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/21
 */
public class DynamicProxyTest {

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

}
