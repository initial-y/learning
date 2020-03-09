package spring.aop.demo;

import com.google.gson.Gson;

/**
 * @className: AopTestServiceImpl
 * @author: yangxin
 * @date: 2020/3/9
 */
public class AopDemoServiceImpl implements AopDemoService {

    @Override
    public void testAopParamCheck(AopDemoQuery query) {
        System.out.println(new Gson().toJson(query));
    }
}
