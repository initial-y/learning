package designpattern.command;

/**
 * @author initial.y
 * @className RemoteControlInvoker
 * @description 命令模式-Invoker
 * @date 2022/03/30
 */
public class RemoteControlInvoker {

    private Command command;

    public RemoteControlInvoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
 }
