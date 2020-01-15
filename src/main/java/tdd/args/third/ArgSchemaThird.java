package tdd.args.third;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArgSchemaThird {

    private Map<String, String> schemaMap;

    public ArgSchemaThird(String schemaStr) {
        this.schemaMap = new HashMap<>(4);
        schemaMap = Stream.of(schemaStr.split(";")).collect(Collectors.toMap(m -> m.split(":")[0], m -> m.split(":")[1]));
    }


    public Object getValue(String key, String param) {
        String type = schemaMap.get(key);
        if (type == null) {
            return null;
        }
        switch (type) {
            case "int":
                return param != null ? Integer.parseInt(param) : 0;
            case "bool":
                return param == null || Boolean.parseBoolean(param);
            default:
                return param;
        }
    }


}
