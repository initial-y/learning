package designpattern.adaptor;

/**
 * 适配器-基于类继承的Adaptor
 * @author initial.y
 * @className AdpatorByExtends
 * @description
 * @date 2021/8/15
 */
public class AdpatorByExtends extends Adaptee implements Target{

    @Override
    public void request() {
        // 继承Adaptee调用接口
        super.adapteeRequest();
    }
}
