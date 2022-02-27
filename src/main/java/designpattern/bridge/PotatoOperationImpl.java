package designpattern.bridge;

/**
 * @author initial.y
 * @className PotatoOperationImpl
 * @description 桥接模式-ConcreteImplementation角色
 * @date 2022/2/27
 */
public class PotatoOperationImpl implements IFoodOperation{
    @Override
    public void wash() {
        System.out.println("wash potato");
    }

    @Override
    public void slice() {
        System.out.println("slice potato");
    }

    @Override
    public void make() {
        System.out.println("make potato");
    }
}
