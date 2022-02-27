package designpattern.bridge;

/**
 * @author initial.y
 * @className BoilCook
 * @description 桥接模式-RefinedAbstraction角色2
 * @date 2022/2/27
 */
public class BoilCook extends AbstractCook {

    public BoilCook(IFoodOperation foodOperation) {
        super(foodOperation);
    }

    @Override
    public void cook() {
        super.cook();
        // 差异化操作
        System.out.println("cook by boil");
    }
}
