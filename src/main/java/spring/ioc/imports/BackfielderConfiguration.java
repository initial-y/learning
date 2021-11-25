package spring.ioc.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author initial.y
 * @className BackfielderConfiguration
 * @description
 * @date 2021/09/16
 */
@Configuration
public class BackfielderConfiguration {

    @Bean(name = "centralBackFielder")
    public Backfielder backfielder() {
        return new Backfielder();
    }

}
