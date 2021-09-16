package spring.ioc.imports;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author xin.yang
 * @className TestConditionalApplication
 * @description
 * @date 2021/09/16
 */
public class TestConditionalApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("spring.ioc.imports");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out :: println);
    }
}
