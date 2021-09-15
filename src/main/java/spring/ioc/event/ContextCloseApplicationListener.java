package spring.ioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xin.yang
 * @className ContextCloseApplicationListener
 * @description
 * @date 2021/09/15
 */
@Component
public class ContextCloseApplicationListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("监听到 ContextClosedEvent 事件消息");
    }
}
