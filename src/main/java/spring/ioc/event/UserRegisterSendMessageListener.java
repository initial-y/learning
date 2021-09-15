package spring.ioc.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xin.yang
 * @className UserRegisterSendMessageListener
 * @description
 * @date 2021/09/15
 */
@Component
public class UserRegisterSendMessageListener {


    @EventListener
    public void eventListener(UserRegisterEvent event) {
        System.out.println("用户注册, 发送消息");
    }
}
