package designpattern.abstractfactory;

/**
 * 抽象工厂模式 - 具体产品实现类B1
 * @ClassName ConcreteProductB1
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public class ConcreteProductB1 implements IAbstractProductB {
    @Override
    public void methodB() {
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
