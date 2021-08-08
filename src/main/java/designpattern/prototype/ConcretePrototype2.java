package designpattern.prototype;

/**
 * @author initial.y
 * @className ConcretePrototype2
 * @description
 * @date 2021/8/8
 */
public class ConcretePrototype2 implements ProtoType{

    @Override
    public ProtoType clone() {
        try {
            return (ProtoType) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
