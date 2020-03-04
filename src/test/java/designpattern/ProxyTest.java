package designpattern;

import designpattern.proxy.Proxy;
import designpattern.proxy.RealSubject;
import designpattern.proxy.SubJect;
import org.junit.Test;

/**
 * 代理模式-Client模拟调用
 * @ClassName ProxyTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/4
 */
public class ProxyTest {

    @Test
    public void test_real_subject() {
        SubJect realSubject = new RealSubject();
        realSubject.request();
    }

    /**
     * 通过代理类Proxy调用RealSubject的request(), 并在前后添加其他操作
     */
    @Test
    public void test_proxy() {
        SubJect proxy = new Proxy();
        proxy.request();
    }

}
