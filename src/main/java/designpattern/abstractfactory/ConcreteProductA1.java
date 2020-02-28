package designpattern.abstractfactory;

/**
 * 抽象工厂模式 - 具体产品实现类A1
 * @ClassName ConcreteProductA1
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public class ConcreteProductA1 implements IAbstractProductA {
    @Override
    public void methodA() {
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
