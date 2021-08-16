package spring.ioc.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author initial.y
 * @className ComponentB
 * @description
 * @date 2021/8/15
 */
@Component
public class ComponentB {

    private ComponentA componentA;

    /**
     * 构造器注入启动时会抛出循环依赖错误
     * @param componentA
     */
    @Autowired
    public ComponentB(ComponentA componentA) {
        this.componentA = componentA;
    }

    public void methodB() {

    }

}
