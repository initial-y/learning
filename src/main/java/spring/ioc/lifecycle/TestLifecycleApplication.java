package spring.ioc.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author initial.y
 * @className TestLifecycleApplication
 * @description
 * @date 2021/09/22
 */
public class TestLifecycleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(LifecycleBeanPostProcessor.class);
        ctx.register(LifecycleSourceConfiguration.class);
        ctx.register(LifecycleDestructionAwareBeanPostProcessor.class);

        System.out.println("================准备刷新IOC容器==================");

        ctx.refresh();

        System.out.println("================IOC容器刷新完毕==================");

        ctx.start();

        System.out.println("================IOC容器启动完成==================");

        Player player = ctx.getBean(Player.class);
        System.out.println(player);
        Trainer trainer = ctx.getBean(Trainer.class);
        System.out.println(trainer);

        System.out.println("================准备停止IOC容器==================");

        ctx.stop();

        System.out.println("================IOC容器停止成功==================");

        ctx.close();
    }
}
