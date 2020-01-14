package tdd.args.second;

import java.util.HashMap;
import java.util.Map;

public class ArgSchemaSecond {

    private Map<String, String> schemaMap = new HashMap<>(4);

    public ArgSchemaSecond(String schemaStr) {
        String[] schemaArr = schemaStr.split(";");
        for (String schemas : schemaArr) {
            String[] schema = schemas.split(":");
            String key = schema[0];
            String value = schema.length > 1 ? schema[1] : null;
            schemaMap.put(key, value);
        }
    }

    public Object getValue(String key, String valueStr) {
        Object value;
        String type = schemaMap.get(key);
        if (type == null) {
            return null;
        }
        switch (type) {
            case "int":
                value = valueStr != null ? Integer.parseInt(valueStr) : 0;
                break;
            case "bool":
                value = valueStr == null || "true".equals(valueStr);
                break;
            default:
                value = valueStr;
        }
        return value;
    }

}
