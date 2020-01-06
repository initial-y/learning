package tdd.args.first;

/**
 * @className: ArgParam
 * @author: yangxin
 * @date: 2020/1/6
 */
public class ArgParam {
    private String key;

    private int value;

    public ArgParam(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
