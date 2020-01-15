package tdd.args.third;

public class ArgParserThird {

    private ArgSchemaThird schema;

    private ArgCommandThird command;

    public ArgParserThird(String schemaStr, String commandStr) {
        this.schema = new ArgSchemaThird(schemaStr);
        this.command = new ArgCommandThird(commandStr);
    }

    public Object getValue(String key) {
        return schema.getValue(key, command.getValue(key));
    }
}
