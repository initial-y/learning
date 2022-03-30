package designpattern.command;

/**
 * @author initial.y
 * @className Client
 * @description 命令模式-客户端调用
 * @date 2022/03/30
 */
public class Client {

    public static void main(String[] args) {
        TVReceiver tvReceiver = new TVReceiver();
        RemoteControlInvoker invoker = new RemoteControlInvoker(new OnOffCommand(tvReceiver));
        // 开机
        invoker.invoke();
        // 关机
//        invoker.invoke();

        // 音量+-
        invoker.setCommand(new VolumeCommand(tvReceiver, VolumeCommand.VolumeOperationEnum.UP));
        invoker.invoke();
        invoker.invoke();
        invoker.setCommand(new VolumeCommand(tvReceiver, VolumeCommand.VolumeOperationEnum.DOWN));
        invoker.invoke();

        // 频道+-
        invoker.setCommand(new ChannelCommand(tvReceiver, ChannelCommand.ChannelOperationEnum.UP));
        invoker.invoke();
        invoker.invoke();
        invoker.setCommand(new ChannelCommand(tvReceiver, ChannelCommand.ChannelOperationEnum.DOWN));
        invoker.invoke();

    }

}
