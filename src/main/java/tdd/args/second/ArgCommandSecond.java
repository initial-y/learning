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
            if (iterator.startsWith("-") && iterator.substring(1).matches("\\D")) {
                String value = null;
                if (commandIterator.hasNext()) {
                    String next = commandIterator.next();
                    if (next.startsWith("-") && next.substring(1).matches("\\D")) {
                        commandIterator.previous();
                    } else {
                        value = next;
                    }
                }
                commandMap.put(iterator.substring(1), value);
            }

        }
    }

    public String getValue(String key) {
        return commandMap.get(key);
    }
}
