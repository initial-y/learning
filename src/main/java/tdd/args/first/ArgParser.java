package tdd.args.first;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @className: ArgParser
 * @date: 2020/1/8
 */
public class ArgParser {

    private final List<ArgCommand> commands;
    private final List<ArgSchema> schemas;

    public ArgParser(String schemaStr, String commandStr) {
        this.schemas = getSchemas(schemaStr);
        this.commands = getCommands(commandStr);
    }

    private List<ArgCommand> getCommands(String commandStr) {
        return Stream.of(commandStr.split("^-|\\s+-(?!\\d)"))
                .filter(command -> !"".equals(command)).map(ArgCommand::new).collect(Collectors.toList());
    }

    private List<ArgSchema> getSchemas(String schemaStr) {
        return Stream.of(schemaStr.split(";")).map(schema -> {
            String[] schemaArr = schema.split(":");
            return new ArgSchema(schemaArr[0], schemaArr[1]);
        }).collect(Collectors.toList());
    }

    public Object getValue(String p) {
        ArgSchema argSchema = schemas.stream().filter(schema -> p.equals(schema.getKey())).findFirst().orElse(null);
        ArgCommand argCommand = commands.stream().filter(command -> p.equals(command.getKey())).findFirst().orElse(null);
        if (Objects.nonNull(argSchema) && Objects.nonNull(argCommand)) {
            return argSchema.getValue(argCommand.getValue());
        }
        return null;
    }
}
