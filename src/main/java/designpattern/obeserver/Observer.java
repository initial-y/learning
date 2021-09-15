package designpattern.obeserver;

/**
 * 观察者模式-观察者抽象
 * @className Observer
 * @description
 * @author initial.y
 * @date 2021/9/15
 */
public interface Observer {

    /**
     * 观察者处理接口, 具体处理逻辑由子类实现
     */
    void update();

}
