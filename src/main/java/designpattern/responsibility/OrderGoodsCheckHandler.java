package designpattern.responsibility;

/**
 * ConcreteHandler角色
 * @author initial.y
 * @className OrderGoodsCheckHandler
 * @description
 * @date 2022/3/6
 */
public class OrderGoodsCheckHandler extends AbstractOrderCheckHandler{
    @Override
    public void check() {
        System.out.println("这里是商品校验...");
        if (next != null) {
            next.check();
        }
    }
}
