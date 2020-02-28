package designpattern.abstractfactory;

/**
 * 抽象工厂模式 - 具体工厂类2， 生产ProductA2,ProductB2产品
 * @ClassName ConcreteFactory2
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public class ConcreteFactory2 implements IAbstractFactory {
    @Override
    public IAbstractProductA createConcreteProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public IAbstractProductB createConcreteProductB() {
        return new ConcreteProductB2();
    }
}
