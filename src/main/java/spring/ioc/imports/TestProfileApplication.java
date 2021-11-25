package spring.ioc.imports;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author initial.y
 * @className TestProfileApplication
 * @description
 * @date 2021/09/16
 */
public class TestProfileApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("Roma");
        ctx.register(SoccerConfiguration.class);
        ctx.refresh();
        ctx.close();
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
