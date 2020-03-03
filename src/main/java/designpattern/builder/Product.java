package designpattern.builder;

/**
 * 建造者模式-具体产品角色
 * @ClassName Product
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/3
 */
public class Product {

    private String partA;

    private String partB;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }
}
