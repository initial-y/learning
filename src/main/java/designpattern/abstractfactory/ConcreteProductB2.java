package designpattern.abstractfactory;

/**
 * 抽象工厂模式 - 具体产品实现类B2
 * @ClassName ConcreteProductB2
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public class ConcreteProductB2 implements IAbstractProductB {
    @Override
    public void methodB() {
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
