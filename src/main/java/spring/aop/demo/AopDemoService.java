package spring.aop.demo;

/**
 * @className: AopTestService
 * @author: yangxin
 * @date: 2020/3/9
 */
public interface AopDemoService {

    @MethodParamCheck(fileds = {"name", "type"})
    void testAopParamCheck(AopDemoQuery query);

}
