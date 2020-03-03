package designpattern.builder;

/**
 * 建造者模式-Builder角色
 * @ClassName Builder
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/3
 */
public abstract class Builder {

    /**
     * 构造具体产品方法A
     */
    abstract void buildPartA();

    /**
     * 构造具体产品方法B
     */
    abstract void buildPartB();

    /**
     * 获取具体产品
     * @return
     */
    abstract Product getProduct();

}
