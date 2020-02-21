package spring.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
