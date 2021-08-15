package designpattern.adaptor;

/**
 * 适配器-基于对象组合的Adaptor
 * @author initial.y
 * @className Adaptor
 * @description
 * @date 2021/8/15
 */
public class Adaptor implements Target{

    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // 通过组合的方式委托给Adaptee
        adaptee.adapteeRequest();
    }
}
