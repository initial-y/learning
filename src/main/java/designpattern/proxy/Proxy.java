package designpattern.proxy;

/**
 * 代理模式-Proxy角色
 * @ClassName Proxy
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/4
 */
public class Proxy implements SubJect {

    /**
     * 原始主体类RealSubject, 可以只在必要是生成实例对象
     */
    private RealSubject realSubject = new RealSubject();

    @Override
    public void request() {
        beforeRequest();
        // RealSubject的调用方法
        realSubject.request();
        afterRequest();
    }

    public void beforeRequest() {
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void afterRequest() {
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
