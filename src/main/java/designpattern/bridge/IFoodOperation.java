package designpattern.bridge;

/**
 * @author initial.y
 * @className IFoodOperation
 * @description 桥接模式-Implementation抽象
 * @date 2022/2/27
 */
public interface IFoodOperation {

    void wash();

    void slice();

    void make();
}
