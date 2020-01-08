package tdd.args.first;

/**
 * @className: ArgSchema
 * @author: yangxin
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
            case "bool" :
                value = (str != null && !"".equals(str)) && str.equalsIgnoreCase("true");
                break;
            case "int" :
                value = str != null && !"".equals(str) ? Integer.parseInt(str) : 0;
                break;
            default:
                value = str;
        }
        return value;
    }
}
