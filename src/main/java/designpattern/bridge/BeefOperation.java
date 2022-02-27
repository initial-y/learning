package designpattern.bridge;

/**
 * @author initial.y
 * @className BeefOperation
 * @description 桥接模式-ConcreteImplementation
 * @date 2022/2/27
 */
public class BeefOperation implements IFoodOperation{
    @Override
    public void wash() {
        System.out.println("wash beef");
    }

    @Override
    public void slice() {
        System.out.println("slice beef");
    }

    @Override
    public void make() {
        System.out.println("make beef");
    }
}
