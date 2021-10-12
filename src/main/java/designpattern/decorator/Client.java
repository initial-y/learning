package designpattern.decorator;

/**
 * 装饰模式客户端模拟
 * @author initial.y
 * @className Client
 * @description
 * @date 2021/10/6
 */
public class Client {

    public static void main(String[] args) {
        // 原始效果
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.operation();

        // 不同的装饰器不同的装饰效果
        Decorator decoratorA = new ConcreteDecoratorA(new ConcreteComponent());
        decoratorA.operation();

        Decorator decoratorB = new ConcreteDecoratorB(new ConcreteComponent());
        decoratorB.operation();
    }
}
