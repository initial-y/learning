package tdd.args.first;

/**
 * @className: ArgCommand
 * @date: 2020/1/9
 */
public class ArgCommand {
    private final String key;
    private final String value;

    public ArgCommand(String commandStr) {
        String[] commandArr = commandStr.split("\\s+");
        this.key = commandArr[0];
        this.value = commandArr.length > 1 ? commandArr[1] : null;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
