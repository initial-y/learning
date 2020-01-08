package tdd.args.first;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @className: ArgParser
 * @author: yangxin
 * @date: 2020/1/8
 */
public class ArgParser {

    private List<ArgSchema> schemas;

    public ArgParser(String schemaStr, String commandStr) {
        this.schemas = getSchemas(schemaStr);

//        Stream.of(commandStr.split("(^\\s+)|-")).filter(command -> !"".equals(command))
//                .map(command -> {
//                    String[] commandArr = command.split("\\s+");
//                    return new
//                }).collect(Collectors.toList());

    }

    private List<ArgSchema> getSchemas(String schemaStr) {
        return Stream.of(schemaStr.split(";")).map(schema -> {
            String[] schemaArr = schema.split(":");
            return new ArgSchema(schemaArr[0], schemaArr[1]);
        }).collect(Collectors.toList());
    }

    public Object getValue(String p) {

        return 8080;

    }
}
