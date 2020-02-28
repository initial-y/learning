package designpattern;

import designpattern.abstractfactory.*;
import org.junit.Test;

/**
 * @ClassName AbstractFactoryTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory1 () {
        // 抽象工厂1
        IAbstractFactory factory1 = new ConcreteFactory1();
        // 工厂1生成A1，B1类具体产品
        IAbstractProductA productA = factory1.createConcreteProductA();
        productA.methodA();
        IAbstractProductB productB = factory1.createConcreteProductB();
        productB.methodB();
    }

    @Test
    public void testAbstractFactory2() {
        // 抽象工厂2
        IAbstractFactory factory2 = new ConcreteFactory2();
        // 工厂2生成A2，B2类具体产品
        IAbstractProductA productA = factory2.createConcreteProductA();
        productA.methodA();
        IAbstractProductB productB = factory2.createConcreteProductB();
        productB.methodB();
    }

}
