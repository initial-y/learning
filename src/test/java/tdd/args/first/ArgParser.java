package tdd.args.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ArgParser
 * @date: 2020/1/6
 */
public class ArgParser {
    public Map<String, ArgParam> parseText(String input) {

        HashMap map = new HashMap<String, Object>();
        map.put("p", new ArgParam("p", 8080));
        return map;
    }
}
