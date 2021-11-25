package spring.ioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author initial.y
 * @className UserRegisterSendMailListener
 * @description
 * @date 2021/09/15
 */
@Component
public class UserRegisterSendMailListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("用户注册, 发送邮箱");
    }

}
