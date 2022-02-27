package designpattern.bridge;

/**
 * @author initial.y
 * @className BridgeClient
 * @description 桥接模式-客户端调用
 * @date 2022/2/27
 */
public class BridgeClient {

    public static void main(String[] args) {
        // fry potato
        AbstractCook fryPotato = new FryCook(new PotatoOperationImpl());
        fryPotato.cook();

        // boil beef
        AbstractCook boilBeef = new BoilCook(new BeefOperation());
        boilBeef.cook();
    }
}
