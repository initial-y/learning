package designpattern.abstractfactory;

/**
 * 抽象工厂模式 - 抽象工厂接口
 * 抽象工厂角色使用接口只能提供接口， 使用抽象类既可以提供抽象方法（子类实现），也可以提供普通方法（自己实现）
 * 接口更符合接口隔离原则， 抽象类更灵活
 * @ClassName IAbstractFactory
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/28
 */
public interface IAbstractFactory {

    IAbstractProductA createConcreteProductA();

    IAbstractProductB createConcreteProductB();

}
