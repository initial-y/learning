package spring.ioc.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author xin.yang
 * @className CoachConfiguration
 * @description
 * @date 2021/09/16
 */
@Conditional(CoachCondition.class)
@Configuration
public class CoachConfiguration {

//    @Profile("Manchester")
    @Bean(name = "pep")
    public Coach pep() {
        return new Coach();
    }

    @Profile("Roma")
    @Bean(name = "jose")
    public Coach jose() {
        return new Coach();
    }

}
