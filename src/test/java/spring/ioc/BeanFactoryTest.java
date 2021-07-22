package spring.ioc;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author initial.y
 * @className BeanFactoryTest
 * @description
 * @date 2021/7/22
 */
class BeanFactoryTest {

    @Test
    void getBean() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("iocDao"));
        }
    }

    @Test
    void getSingletonBean() {
        IntStream.range(1, 10).parallel().forEach(i -> {
            System.out.println(Thread.currentThread().getName() + ":" +  BeanFactory.getSingletonBean("iocDao"));
        });
    }

    @Test
    void beanFactoryGetBean() {
        BeanFactoryTest test = (BeanFactoryTest) BeanFactory.getBean("spring.ioc.BeanFactoryTest");
        System.out.println(test);
    }
}