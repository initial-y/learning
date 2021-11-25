package spring.ioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author initial.y
 * @className RefreshApplicationListener
 * @description
 * @date 2021/09/15
 */
@Component
public class RefreshApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("RefreshApplicationListener 监听 ContextRefreshEvent事件");
    }
}
