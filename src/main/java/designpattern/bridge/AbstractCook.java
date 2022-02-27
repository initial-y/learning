package designpattern.bridge;

/**
 * @author initial.y
 * @className AbstractCook
 * @description 桥接模式-Abstraction角色
 * @date 2022/2/27
 */
public abstract class AbstractCook {

    /**
     * 想做复杂的菜品，可以扩展IFoodOperation，比如List<IFoodOperation>, 满汉全席也不是不可以
     */
    protected IFoodOperation foodOperation;

    public AbstractCook(IFoodOperation foodOperation) {
        this.foodOperation = foodOperation;
    }

    /**
     * 桥接foodOperation
     */
    public void cook() {
        foodOperation.wash();
        foodOperation.slice();
        foodOperation.make();
    }
}
