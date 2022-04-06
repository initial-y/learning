package designpattern.responsibility;

/**
 * @author initial.y
 * @className Client
 * @description
 * @date 2022/3/6
 */
public class Client {

    public static void main(String[] args) {
        AbstractOrderCheckHandler checkHandler = new OrderGoodsCheckHandler();
        // 设置next, 链式调用
        checkHandler.setNext(new OrderStockCheckHandler())
                .setNext(new OrderDiscountCheckHandler());
        checkHandler.check();
    }
}
