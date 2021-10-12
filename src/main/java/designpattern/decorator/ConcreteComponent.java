package designpattern.decorator;

/**
 * 装饰模式-具体组件
 * @author initial.y
 * @className ConcreteComponent
 * @description
 * @date 2021/10/6
 */
public class ConcreteComponent extends Component{
    @Override
    public void operation() {
        System.out.println("ConcreteComponent...");
    }
}
