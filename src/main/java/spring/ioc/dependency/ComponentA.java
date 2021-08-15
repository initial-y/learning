package spring.ioc.dependency;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author initial.y
 * @className ComponentA
 * @description
 * @date 2021/8/15
 */
@Component
public class ComponentA {

    @Resource
    private ComponentB componentB;
}
