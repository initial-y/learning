package designpattern.abstractfactory;

/**
 * 抽象工厂模式 - 具体工厂类1, 生产ProductA1,ProductB1产品
 * @ClassName ConcreteFactory1
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public class ConcreteFactory1 implements IAbstractFactory {

    @Override
    public IAbstractProductA createConcreteProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public IAbstractProductB createConcreteProductB() {
        return new ConcreteProductB1();
    }
}
