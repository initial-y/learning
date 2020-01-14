package tdd.args.second;

public class ArgParserSecond {


    private final ArgSchemaSecond argSchema;
    private final ArgCommandSecond argCommand;

    public ArgParserSecond(String schemaStr, String commandStr) {
        this.argSchema = new ArgSchemaSecond(schemaStr);
        this.argCommand = new ArgCommandSecond(commandStr);
    }

    public Object getValue(String key) {
        return argSchema.getValue(key, argCommand.getValue(key));
    }
}
