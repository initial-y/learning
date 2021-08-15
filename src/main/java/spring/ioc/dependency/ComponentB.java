package spring.ioc.dependency;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author initial.y
 * @className ComponentB
 * @description
 * @date 2021/8/15
 */
@Component
public class ComponentB {

    @Resource
    private ComponentA componentA;

}
