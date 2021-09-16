package spring.ioc.imports;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解, 测试@Import
 * @className EnableSoccer
 * @description
 * @author initial.y
 * @date 2021/9/16
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// 模块装配 - 普通类
//@Import(GoalKeeper.class)
// 模块装配 - 配置类
//@Import(MidfielderConfiguration.class)
// 模块装配 - ImportSelector实现类
//@Import(BackfielderImportSelector.class)
// 模块装配 - ImportBeanDefinitionRegistrar实现类
@Import({ForwardRegister.class})
public @interface EnableSoccer {
}
