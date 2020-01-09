package tdd.args.first;


import java.util.stream.Stream;

/**
 * @className: ArgSchema
 * @date: 2020/1/8
 */
public class ArgSchema {

    private String key;

    private String type;

    public ArgSchema(String key, String type) {
        this.key = key;
        this.type = type;
    }

    public Object getValue(String str) {
        Object value;
        switch (type) {
            case "bool":
                value = (str != null && !"".equals(str)) && "true".equalsIgnoreCase(str);
                break;
            case "int":
                value = str != null && !"".equals(str) ? Integer.parseInt(str) : 0;
                break;
            case "strArr":
                value = str != null && !"".equals(str) ? str.split(",") : new String[0];
                break;
            case "intArr":
                value = str != null && !"".equals(str) ? Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray() : new int[0];
                break;
            default:
                value = str;
        }
        return value;
    }

    public String getKey() {
        return key;
    }
}
