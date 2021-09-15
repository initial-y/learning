package spring.ioc.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xin.yang
 * @className TestListenerApplication
 * @description
 * @date 2021/09/15
 */
public class TestListenerApplication {

    public static void main(String[] args) {
        System.out.println("ioc容器即将开始初始化...");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("spring.ioc.event");
        System.out.println("ioc容器初始化完毕...");
        ctx.close();
        System.out.println("ioc容器关闭...");
    }

}
