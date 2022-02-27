package designpattern.bridge;

/**
 * @author initial.y
 * @className FryCook
 * @description 桥接模式-RefinedAbstraction角色
 * @date 2022/2/27
 */
public class FryCook extends AbstractCook{

    public FryCook(IFoodOperation foodOperation) {
        super(foodOperation);
    }

    @Override
    public void cook() {
        super.cook();
        // 差异化操作
        System.out.println("cook by fry");
    }
}
