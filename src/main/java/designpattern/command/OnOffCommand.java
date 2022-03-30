package designpattern.command;

/**
 * @author initial.y
 * @className OnOffCommand
 * @description 命令模式-ConcreteCommand
 * @date 2022/03/30
 */
public class OnOffCommand implements Command{

    private TVReceiver tvReceiver;

    public OnOffCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        System.out.println("执行开关机命令");
        tvReceiver.onOff();
    }
}
