package spring.ioc.imports;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xin.yang
 * @className CoachCondition
 * @description
 * @date 2021/09/16
 */
public class CoachCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().containsBean(Coach.class.getName());
    }
}
