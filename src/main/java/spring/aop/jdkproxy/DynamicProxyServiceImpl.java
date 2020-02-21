package spring.aop.jdkproxy;

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
