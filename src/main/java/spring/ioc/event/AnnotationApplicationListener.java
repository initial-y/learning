package spring.ioc.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xin.yang
 * @className AnnotationApplicationListener
 * @description
 * @date 2021/09/15
 */
@Component
public class AnnotationApplicationListener {



    @EventListener
    public void contextClosedEvent(ContextRefreshedEvent event) {
        System.out.println("注解式监听 ContextRefreshedEvent");
    }

    @EventListener
    public void contextRefreshedEvent(ContextRefreshedEvent event) {
        System.out.println("注解式监听 ContextClosedEvent");
    }

    @EventListener
    public void contextStartedEvent(ContextStartedEvent event) {
        System.out.println("注解式监听 ContextStartedEvent");
    }

    @EventListener
    public void contextClosedEvent(ContextClosedEvent event) {
        System.out.println("注解式监听 ContextClosedEvent");
    }

}
