package tdd.args.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @className: ArgCommandThird
 * @date: 2020/1/15
 */
public class ArgCommandThird {

    private String key;

    private String value;

    List<ArgCommandThird> commandList = new ArrayList<>(4);

    public ArgCommandThird(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ArgCommandThird(String commandStr) {
        List<String> commandStrList = Arrays.asList(commandStr.split("\\s+"));
        ListIterator<String> commandIterator = commandStrList.listIterator();
        while (commandIterator.hasNext()) {
            String iterator = commandIterator.next();
            if (iterator.charAt(0) == '-') {
                String key = iterator.substring(1);
                if (commandIterator.hasNext()) {
                    String value = commandIterator.next();
                    if (value.charAt(0) != '-' || value.substring(1).matches("\\d+")) {
                        commandList.add(new ArgCommandThird(key, value));
                    } else {
                        commandIterator.previous();
                    }
                }
            }
        }
    }

    public String getValue(String key) {
        ArgCommandThird cmd = commandList.stream().filter(command -> command.key.equals(key)).findFirst().orElse(null);
        return cmd != null ? cmd.value : null;
    }
}
