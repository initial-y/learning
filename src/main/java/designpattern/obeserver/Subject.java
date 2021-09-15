package designpattern.obeserver;

/**
 * 观察者模式-被观察者抽象
 * @className Subject
 * @description
 * @author initial.y
 * @date 2021/9/15
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

}
