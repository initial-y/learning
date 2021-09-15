package spring.ioc.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xin.yang
 * @className UserRegisterListenerApplication
 * @description
 * @date 2021/09/15
 */
public class UserRegisterListenerApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("spring.ioc.event");
        UserRegisterService userRegisterService = ctx.getBean(UserRegisterService.class);
        userRegisterService.register("test");
    }

}
