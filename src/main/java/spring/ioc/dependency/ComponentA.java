package spring.ioc.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author initial.y
 * @className ComponentA
 * @description
 * @date 2021/8/15
 */
@Component
public class ComponentA {

    private ComponentB componentB;

    @Autowired
    public ComponentA(ComponentB componentB) {
        this.componentB = componentB;
    }

    public void methodA() {
        componentB.methodB();
    }
}
