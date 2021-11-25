package spring.ioc.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author initial.y
 * @className UserRegisterService
 * @description
 * @date 2021/09/15
 */
@Component
public class UserRegisterService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void register(String username) {
        System.out.println("用户注册成功...");
        System.out.println("开始发布用户注册成功事件...");
        publisher.publishEvent(new UserRegisterEvent(username));
        System.out.println("用户注册成功事件发布成功...");
    }
}
