package designpattern.command;

/**
 * @author initial.y
 * @className ChannelCommand
 * @description 命令模式-ConcreteCommand
 * @date 2022/03/30
 */
public class ChannelCommand implements Command {

    private TVReceiver tvReceiver;

    private ChannelOperationEnum channelOperation;

    public ChannelCommand(TVReceiver tvReceiver, ChannelOperationEnum channelOperation) {
        this.tvReceiver = tvReceiver;
        this.channelOperation = channelOperation;
    }

    @Override
    public void execute() {
        if (channelOperation == ChannelOperationEnum.UP) {
            tvReceiver.channelUp();
        } else {
            tvReceiver.channelDown();
        }
    }

    public enum ChannelOperationEnum {
        UP,
        DOWN
    }
}
