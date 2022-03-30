package designpattern.command;

/**
 * @author initial.y
 * @className VolumeCommand
 * @description 命令模式-ConcreteCommand
 * @date 2022/03/30
 */
public class VolumeCommand implements Command {

    private TVReceiver tvReceiver;

    private VolumeOperationEnum operation;

    public VolumeCommand(VolumeOperationEnum operation) {
        tvReceiver = new TVReceiver();
        this.operation = operation;
    }

    public VolumeCommand(TVReceiver tvReceiver, VolumeOperationEnum operation) {
        this.tvReceiver = tvReceiver;
        this.operation = operation;
    }

    @Override
    public void execute() {
        if (operation == VolumeOperationEnum.UP) {
            tvReceiver.volumeUp();
        } else {
            tvReceiver.volumeDown();
        }
    }

    public enum VolumeOperationEnum {
        UP,
        DOWN
    }
}
