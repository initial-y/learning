package spring.ioc.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author initial.y
 * @className UserRegisterEvent
 * @description
 * @date 2021/09/15
 */
public class UserRegisterEvent extends ApplicationEvent {

    public UserRegisterEvent(Object source) {
        super(source);
    }
}
