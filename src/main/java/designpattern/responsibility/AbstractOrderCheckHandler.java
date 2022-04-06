package designpattern.responsibility;

/**
 * handler角色
 * @author initial.y
 * @className AbstractOrderCheckHandler
 * @description
 * @date 2022/3/6
 */
public abstract class AbstractOrderCheckHandler {

    /**
     * 下个处理节点
     */
    public AbstractOrderCheckHandler next;

    public AbstractOrderCheckHandler setNext(AbstractOrderCheckHandler nextHandler) {
        next = nextHandler;
        return nextHandler;
    }

    /**
     * 具体校验流程
     */
    public abstract void check();

}
