package tdd.args.first;

import java.util.ArrayList;
import java.util.List;

public class ArgSchema {

    private int argNum;

    private List<ArgParam> argParams;

    public ArgSchema(int argNum, ArrayList<ArgParam> argParams) {
        this.argNum = argNum;
        this.argParams = argParams;
    }
}
