package designpattern.prototype;

/**
 * @author initial.y
 * @className ConcretePrototype1
 * @description
 * @date 2021/8/8
 */
public class ConcretePrototype1 implements ProtoType{
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
