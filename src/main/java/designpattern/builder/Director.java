package designpattern.builder;

/**
 * 建造者模式-指挥者角色
 * @ClassName Director
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/3
 */
public class Director {

    private Builder builder;

    /**
     * 构造函数
     * 实际传入的参数是Builder抽象类的子类
     * @param builder
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 实际构建对象的方法
     */
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        return builder.getProduct();
    }

}
