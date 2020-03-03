package designpattern.builder;

/**
 * 建造者模式-具体建造者角色
 * @ClassName ConcreteBuilderTwo
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/3
 */
public class ConcreteBuilderTwo extends Builder {

    private Product product = new Product();

    @Override
    void buildPartA() {
        product.setPartA(this.getClass().getSimpleName());
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    void buildPartB() {
        product.setPartB(this.getClass().getSimpleName());
        System.out.println(this.getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    Product getProduct() {
        return product;
    }
}
