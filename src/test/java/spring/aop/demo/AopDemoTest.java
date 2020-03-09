package spring.aop.demo;

import org.junit.Test;

/**
 * @className: AopDemoTest
 * @author: yangxin
 * @date: 2020/3/9
 */
public class AopDemoTest {

    private final AopDemoService aopDemoService = new AopDemoServiceImpl();

    @Test
    public void test_method_with_aop() {
        aopDemoService.testAopParamCheck(new AopDemoQuery());
    }


}
