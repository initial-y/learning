package designpattern.prototype;

/**
 * 原型模式-Prototype
 * @author initial.y
 * @className ProtoType
 * @description
 * @date 2021/8/8
 */
public interface ProtoType extends Cloneable {

    ProtoType clone();
}
