package spring.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author initial.y
 * @className LifecycleDestructionAwareBeanPostProcessor
 * @description
 * @date 2021/09/22
 */
public class LifecycleDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (bean instanceof Player) {
            Player player = (Player) bean;
            System.out.println("DestructionAwareBeanPostProcessor.postProcessBeforeDestruction, player.getName(): " + player.getName());
        }
    }
}
