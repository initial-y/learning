package designpattern;

import com.google.gson.Gson;
import designpattern.builder.ConcreteBuilderOne;
import designpattern.builder.ConcreteBuilderTwo;
import designpattern.builder.Director;
import designpattern.builder.Product;
import org.junit.Test;

/**
 * 建造者模式-客户端类模拟调用
 * @ClassName BuilderTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/3/2
 */
public class BuilderTest {

    /**
     * 通过ConcreteBuilderOne构建对象
     */
    @Test
    public void test_builder_one() {
        Director director = new Director(new ConcreteBuilderOne());
        Product product = director.construct();
        System.out.println(new Gson().toJson(product));
    }

    /**
     * 通过ConcreteBuilderTwo构建对象
     */
    @Test
    public void test_builder_two() {
        Director director = new Director(new ConcreteBuilderTwo());
        Product product = director.construct();
        System.out.println(new Gson().toJson(product));
    }

}
