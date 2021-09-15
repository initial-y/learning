package designpattern.obeserver;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者-ConcreteSubject角色
 * @author initial.y
 * @className ConcreteSubject
 * @description
 * @date 2021/09/15
 */
public class ConcreteSubject implements Subject{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
