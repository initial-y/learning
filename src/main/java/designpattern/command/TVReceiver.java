package designpattern.command;

import lombok.Data;

/**
 * @author initial.y
 * @className TVReceiver
 * @description 命令模式-Receiver角色
 * @date 2022/03/30
 */
@Data
public class TVReceiver {

    /**
     * 开机状态
     */
    private boolean isOpen;

    /**
     * 音量
     */
    private int volume;

    /**
     * 频道
     */
    private int channel;

    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;


    public void onOff() {
        isOpen = !isOpen;
        System.out.println("电视已" + (isOpen ? "开机" : "关机"));
    }

    public void volumeUp() {
        if (isOpen && volume < MAX_VOLUME) {
            volume++;
            System.out.println("调大音量, 当前音量:" + volume);
        }
    }

    public void volumeDown() {
        if (isOpen && volume > MIN_VOLUME) {
            volume--;
            System.out.println("调小音量, 当前音量:" + volume);
        }
    }

    public void channelUp() {
        if (isOpen) {
            channel++;
            System.out.println("频道加, 当前频道:" + channel);
        }
    }

    public void channelDown() {
        if (isOpen && channel > 0) {
            channel--;
            System.out.println("频道减, 当前频道:" + channel);
        }
    }
}
