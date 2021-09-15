package designpattern.obeserver;

/**
 * 观察者模式-具体观察者
 * @author initial.y
 * @className ConcreteObserver
 * @description
 * @date 2021/09/15
 */
public class ConcreteObserverOne implements Observer{

    @Override
    public void update() {
        System.out.println("ConcreteObserverOne业务逻辑");
    }
}
