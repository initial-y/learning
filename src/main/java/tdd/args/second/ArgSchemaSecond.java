package tdd.args.second;

public class ArgSchemaSecond {

    private String type;

    public ArgSchemaSecond(String type) {
        this.type = type;
    }

    public Object getValue(String str) {
        Object value;
        switch (type) {
            case "int":
                value = Integer.parseInt(str);
                break;
            case "bool":
                value = "true".equals(str);
                break;
            default:
                value = str;
        }
        return value;
    }
}
