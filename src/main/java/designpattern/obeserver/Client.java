package designpattern.obeserver;

/**
 * @author initial.y
 * @className Client
 * @description
 * @date 2021/09/15
 */
public class Client {

    public static void main(String[] args) {
        // 被观察者
        Subject subject = new ConcreteSubject();
        // 注册观察者
        subject.attach(new ConcreteObserverOne());
        subject.attach(new ConcreteObserverTwo());
        // 通知观察者处理业务逻辑
        subject.notifyObservers();
    }

}
