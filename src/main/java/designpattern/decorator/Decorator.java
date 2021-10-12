package designpattern.decorator;

/**
 * 装饰模式-装饰抽象类
 * @author initial.y
 * @className Decorator
 * @description
 * @date 2021/10/6
 */
public abstract class Decorator extends Component {

    /**
     * 被装饰者
     */
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
