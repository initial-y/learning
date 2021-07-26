package spring.ioc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring.ioc.bean.Dog;

@Configuration
//@PropertySource(value = "classpath:xxx.properties")
public class IocConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
