package designpattern.responsibility;

/**
 * ConcreteHandler角色
 * @author initial.y
 * @className OrderDiscountHandler
 * @description
 * @date 2022/3/6
 */
public class OrderDiscountCheckHandler extends AbstractOrderCheckHandler {

    @Override
    public void check() {
        System.out.println("这里是折扣校验...");
        if (next != null) {
            next.check();
        }
    }
}
