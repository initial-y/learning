package spring.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author initial.y
 * @className LifecycleBeanPostProcessor
 * @description
 * @date 2021/09/22
 */
public class LifecycleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Player) {
            Player player = (Player) bean;
            System.out.println("BeanPostProcessor.postProcessBeforeInitialization, player.getName(): " + player.getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Player) {
            Player player = (Player) bean;
            System.out.println("BeanPostProcessor.postProcessAfterInitialization, player.getName(): " + player.getName());
        }
        return bean;
    }
}
