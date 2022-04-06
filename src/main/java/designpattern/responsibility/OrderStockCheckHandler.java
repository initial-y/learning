package designpattern.responsibility;

/**
 * ConcreteHandler角色
 * @author initial.y
 * @className OrderStockCheckHandler
 * @description
 * @date 2022/3/6
 */
public class OrderStockCheckHandler extends AbstractOrderCheckHandler{

    @Override
    public void check() {
        System.out.println("这里是库存校验...");
        if (next != null) {
            next.check();
        }
    }
}
