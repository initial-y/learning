package designpattern.proxy;

/**
 * 代理模式-RealSubject角色
 * @ClassName RealSubject
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/4
 */
public class RealSubject implements SubJect {
    @Override
    public void request() {
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
