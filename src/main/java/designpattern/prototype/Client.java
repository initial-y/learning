package designpattern.prototype;

/**
 * @author initial.y
 * @className Client
 * @description
 * @date 2021/8/8
 */
public class Client {

    public static void main(String[] args) {
        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
        System.out.println(concretePrototype1);
        ConcretePrototype2 concretePrototype2 = new ConcretePrototype2();
        System.out.println(concretePrototype2);
        for (int i = 0; i < 2; i++) {
            System.out.println("concretePrototype1.clone：" + concretePrototype1.clone());
            System.out.println("concretePrototype2.clone：" + concretePrototype2.clone());
        }

    }

}
