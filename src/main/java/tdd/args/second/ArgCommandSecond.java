package tdd.args.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class ArgCommandSecond {

    private Map<String, String> commandMap = new HashMap<>(4);

    public ArgCommandSecond(String commandStr) {
        String[] commandArr = commandStr.split("\\s+");
        ListIterator<String> commandIterator = Arrays.asList(commandArr).listIterator();
        while (commandIterator.hasNext()) {
            String iterator = commandIterator.next();
            if (!iterator.startsWith("-")) {
                // todo 从尾到前
                if (commandIterator.hasPrevious()) {
                    String key = commandIterator.previous();
                    commandMap.put(key, iterator);
                }
            }

        }
    }

    public String getValue(String key) {
        return commandMap.get(key);
    }
}
