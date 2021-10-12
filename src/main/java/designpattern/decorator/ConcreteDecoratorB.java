package designpattern.decorator;

/**
 * 装饰模式-具体装饰者
 * @author initial.y
 * @className ConcreteDecoratorB
 * @description
 * @date 2021/10/6
 */
public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("--------");
        component.operation();
        System.out.println("--------");
    }
}
