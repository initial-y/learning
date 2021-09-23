package spring.ioc.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xin.yang
 * @className LifecycleSourceConfiguration
 * @description
 * @date 2021/09/22
 */
@Configuration
@ComponentScan("spring.ioc.lifecycle")
public class LifecycleSourceConfiguration {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Player player() {
        Player player = new Player();
        player.setName("m10");
        return player;
    }

}
