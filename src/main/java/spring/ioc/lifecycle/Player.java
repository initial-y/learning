package spring.ioc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author initial.y
 * @className Player
 * @description test bean lifecycle
 * @date 2021/09/22
 */
public class Player implements InitializingBean, DisposableBean, Lifecycle {

    private String name;

    private boolean state = false;

    public Player() {
        System.out.println("bean constructor...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()...");
    }

    public void initMethod() {
        System.out.println("initMethod...");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod...");
    }

    @Override
    public void start() {
        System.out.println("Lifecycle.start()...");
        this.state = true;
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle.stop()...");
        this.state = false;
    }

    @Override
    public boolean isRunning() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
