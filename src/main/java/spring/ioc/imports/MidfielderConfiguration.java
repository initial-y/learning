package spring.ioc.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 *  @Configruation +@Bean本身会注入容器
 *  @Import 可以转配配置Bean
 * @author xin.yang
 * @className MidfielderConfiguration
 * @description
 * @date 2021/09/16
 */
@Conditional(CoachCondition.class)
@Configuration
public class MidfielderConfiguration {

    @Bean(name = "attackMidfielder")
    public Midfielder getAttackMidfielder() {
        return new Midfielder();
    }

    @Bean(name = "defenseMidfielder")
    public Midfielder getDefenseMidfielder() {
        return new Midfielder();
    }
}
