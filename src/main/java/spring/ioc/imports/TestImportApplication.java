package spring.ioc.imports;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 模块装配测试
 * @author xin.yang
 * @className TestImportApplication
 * @description
 * @date 2021/09/16
 */
public class TestImportApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("spring.ioc.imports");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
